package com.gokhantamkoc.personanlwebpage.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gokhantamkoc.personanlwebpage.backend.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.entity.Session;
import com.gokhantamkoc.personanlwebpage.backend.model.LogoutRequest;
import com.gokhantamkoc.personanlwebpage.backend.model.LogoutSuccess;
import com.gokhantamkoc.personanlwebpage.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController extends BaseController {

    @Autowired
    AccountService accountService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> login(@RequestBody Account account) {
        try {
            Session session = accountService.login(account);
            return new ResponseEntity<>(session, HttpStatus.OK);
        } catch (Exception e) {
            return generateError(e);
        }
    }

    @RequestMapping(
            value = "/logout",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> logout(@RequestBody LogoutRequest logoutRequest, @RequestHeader(value = "token") String token) {
        try {
            accountService.logout(logoutRequest, token);
            return new ResponseEntity<>(new LogoutSuccess("Logout successful."), HttpStatus.OK);
        } catch (Exception e) {
            return generateError(e);
        }
    }

    @RequestMapping(
            value = "/update/email",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> updateEmail(@RequestBody Account account, @RequestHeader(value = "token") String token) {
        try {
            accountService.updateEmail(account, token);
            return new ResponseEntity<>("Email updated successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return generateError(e);
        }
    }

    @RequestMapping(
            value = "/update/password",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> updatePassword(@RequestBody Account account, @RequestHeader(value = "token") String token) {
        try {
            accountService.updatePassword(account, token);
            return new ResponseEntity<>("Password updated successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return generateError(e);
        }
    }
}
