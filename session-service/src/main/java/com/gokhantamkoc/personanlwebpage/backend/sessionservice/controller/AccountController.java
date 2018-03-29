package com.gokhantamkoc.personanlwebpage.backend.sessionservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Session;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.service.AccountService;
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
            return generateErrorResponse(e);
        }
    }

    @RequestMapping(
            value = "/update/email",
            method = RequestMethod.PATCH,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> updateEmail(@RequestHeader("Token") String token, @RequestBody Account account) {
        try {
            accountService.updateEmail(account, token);
            return generateSuccessResponse("Email updated successfully!");
        } catch (Exception e) {
            return generateErrorResponse(e);
        }
    }

    @RequestMapping(
            value = "/update/password",
            method = RequestMethod.PATCH,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> updatePassword(@RequestHeader("Token") String token, @RequestBody Account account) {
        try {
            accountService.updatePassword(account, token);
            return generateSuccessResponse("Password updated successfully!");
        } catch (Exception e) {
            return generateErrorResponse(e);
        }
    }

    @RequestMapping(
            value = "/logout",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> logout(@RequestHeader("Token") String token, @RequestBody Account account) {
        try {
            accountService.logout(account.getUsername(), token);
            return generateSuccessResponse("Logout successful!");
        } catch (Exception e) {
            return generateErrorResponse(e);
        }
    }
}
