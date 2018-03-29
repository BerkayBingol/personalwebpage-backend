package com.gokhantamkoc.personanlwebpage.backend.sessionservice.service;

import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Session;

public interface AccountService {
    Session login(Account account) throws Exception;
    Account updateEmail(Account account, String token) throws Exception;
    Account updatePassword(Account account, String token) throws Exception;
    void logout(String username, String token) throws Exception;
}
