package com.gokhantamkoc.personanlwebpage.backend.sessionservice.service;

import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Session;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception.AccountNotFoundException;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception.InvalidAccountCredentialsException;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception.InvalidTokenException;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.repository.AccountRepository;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.repository.SessionRepository;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.utility.TimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public Session login(Account account) throws Exception {
        Account foundAccount = accountRepository.findAccountByUsername(account.getUsername());
        if(foundAccount == null) {
            throw new InvalidAccountCredentialsException();
        }
        else if(!account.getPassword().equals(foundAccount.getPassword())) {
            throw new InvalidAccountCredentialsException();
        } else {
            Session session = sessionRepository.findSessionByAccount(foundAccount);
            if(session != null) {
                updateSession(session);
            } else {
                session = createSession(foundAccount);
            }
            sessionRepository.save(session);
            return session;
        }
    }

    @Override
    public Account updateEmail(Account account, String token) throws Exception {
        if(validateToken(token)) {
            Account foundAccount = accountRepository.findOne(account.getId());
            if(foundAccount == null) {
                throw new AccountNotFoundException();
            }
            foundAccount.setEmail(account.getEmail());
            return accountRepository.save(foundAccount);
        } else {
            throw new InvalidTokenException();
        }
    }

    private boolean validateToken(String token) {
        Session foundSession = sessionRepository.findSessionByToken(UUID.fromString(token));
        if(foundSession == null) {
            return false;
        }
        updateSession(foundSession);
        sessionRepository.save(foundSession);
        return true;
    }

    @Override
    public Account updatePassword(Account account, String token) throws Exception {
        if(validateToken(token)) {
            Account foundAccount = accountRepository.findOne(account.getId());
            if(foundAccount == null) {
                throw new AccountNotFoundException();
            }
            foundAccount.setPassword(account.getPassword());
            return accountRepository.save(foundAccount);
        } else {
            throw new InvalidTokenException();
        }
    }

    private Session createSession(Account account) {
        Session session = new Session();
        session.setAccount(account);
        session.setToken(UUID.randomUUID());
        session.setExpireDate(TimeUtility.addHoursToDate(new Date(), 1));
        return session;
    }

    private void updateSession(Session session) {
        Date now = new Date();
        Date after1Hour = TimeUtility.addHoursToDate(now, 1);
        UUID token = session.getToken();
        if(now.getTime() > session.getExpireDate().getTime() || token == null) {
            session.setToken(UUID.randomUUID());
            session.setExpireDate(after1Hour);
        } else {
            session.setExpireDate(after1Hour);
        }
    }

    @Override
    public void logout(String username, String token) throws Exception {
        Session session = sessionRepository.findSessionByToken(UUID.fromString(token));
        session.setToken(null);
        sessionRepository.save(session);
    }
}
