package com.gokhantamkoc.personanlwebpage.backend.service;

import com.gokhantamkoc.personanlwebpage.backend.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.entity.Session;
import com.gokhantamkoc.personanlwebpage.backend.model.LogoutRequest;

public interface AccountService {
    Session login(Account account) throws Exception;
    void logout(LogoutRequest logoutRequest, String token) throws Exception;
    Account updateEmail(Account account, String token) throws Exception;
    Account updatePassword(Account account, String token) throws Exception;
}
