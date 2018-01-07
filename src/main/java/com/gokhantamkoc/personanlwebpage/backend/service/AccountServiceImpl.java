package com.gokhantamkoc.personanlwebpage.backend.service;

import com.gokhantamkoc.personanlwebpage.backend.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.entity.Session;
import com.gokhantamkoc.personanlwebpage.backend.exception.AccountNotFoundException;
import com.gokhantamkoc.personanlwebpage.backend.exception.InvalidAccountCredentialsException;
import com.gokhantamkoc.personanlwebpage.backend.exception.InvalidTokenException;
import com.gokhantamkoc.personanlwebpage.backend.repository.AccountRepository;
import com.gokhantamkoc.personanlwebpage.backend.repository.SessionRepository;
import com.gokhantamkoc.personanlwebpage.backend.utility.TimeUtility;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountRepository accountRepository;

    @Resource
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
        Session foundSession = sessionRepository.findSessionByToken(token);
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
        if(now.getTime() > session.getExpireDate().getTime()) {
            session.setToken(UUID.randomUUID());

            session.setExpireDate(after1Hour);
        } else {
            session.setExpireDate(after1Hour);
        }
    }
}
