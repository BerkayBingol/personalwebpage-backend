package com.gokhantamkoc.personanlwebpage.backend.sessionservice.service;

<<<<<<< HEAD:src/main/java/com/gokhantamkoc/personanlwebpage/backend/service/AccountServiceImpl.java
import com.gokhantamkoc.personanlwebpage.backend.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.entity.Session;
import com.gokhantamkoc.personanlwebpage.backend.exception.AccountNotFoundException;
import com.gokhantamkoc.personanlwebpage.backend.exception.InvalidAccountCredentialsException;
import com.gokhantamkoc.personanlwebpage.backend.exception.InvalidAccountException;
import com.gokhantamkoc.personanlwebpage.backend.exception.InvalidTokenException;
import com.gokhantamkoc.personanlwebpage.backend.model.LogoutRequest;
import com.gokhantamkoc.personanlwebpage.backend.repository.AccountRepository;
import com.gokhantamkoc.personanlwebpage.backend.repository.SessionRepository;
import com.gokhantamkoc.personanlwebpage.backend.utility.TimeUtility;
=======
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Session;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception.AccountNotFoundException;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception.InvalidAccountCredentialsException;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception.InvalidTokenException;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.repository.AccountRepository;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.repository.SessionRepository;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.utility.TimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> master:session-service/src/main/java/com/gokhantamkoc/personanlwebpage/backend/sessionservice/service/AccountServiceImpl.java
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public void logout(LogoutRequest logoutRequest, String token) throws Exception {
        Session foundSession = sessionRepository.findSessionByToken(java.util.UUID.fromString(token));
        Account foundAccount = accountRepository.findAccountByUsername(logoutRequest.getUsername());
        if(foundAccount != null && foundSession != null) {
            if(foundAccount.getUsername().equals(foundSession.getAccount().getUsername())) {
                foundSession.setToken(null);
                sessionRepository.save(foundSession);
            } else {
                throw new InvalidAccountException();
            }
        } else {
            throw new InvalidAccountException();
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
<<<<<<< HEAD:src/main/java/com/gokhantamkoc/personanlwebpage/backend/service/AccountServiceImpl.java
        Session foundSession = sessionRepository.findSessionByToken(java.util.UUID.fromString(token));
=======
        Session foundSession = sessionRepository.findSessionByToken(UUID.fromString(token));
>>>>>>> master:session-service/src/main/java/com/gokhantamkoc/personanlwebpage/backend/sessionservice/service/AccountServiceImpl.java
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
        session.setToken(java.util.UUID.randomUUID());
        session.setExpireDate(TimeUtility.addHoursToDate(new Date(), 1));
        return session;
    }

    private void updateSession(Session session) {
        Date now = new Date();
        Date after1Hour = TimeUtility.addHoursToDate(now, 1);
<<<<<<< HEAD:src/main/java/com/gokhantamkoc/personanlwebpage/backend/service/AccountServiceImpl.java
        session.setToken(java.util.UUID.randomUUID());
        session.setExpireDate(after1Hour);
=======
        UUID token = session.getToken();
        if(now.getTime() > session.getExpireDate().getTime() || token == null) {
            session.setToken(UUID.randomUUID());
            session.setExpireDate(after1Hour);
        } else {
            session.setExpireDate(after1Hour);
        }
>>>>>>> master:session-service/src/main/java/com/gokhantamkoc/personanlwebpage/backend/sessionservice/service/AccountServiceImpl.java
    }

    @Override
    public void logout(String username, String token) throws Exception {
        Session session = sessionRepository.findSessionByToken(UUID.fromString(token));
        session.setToken(null);
        sessionRepository.save(session);
    }
}
