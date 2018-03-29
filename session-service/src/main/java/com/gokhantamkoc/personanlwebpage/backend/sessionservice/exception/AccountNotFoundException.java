package com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException() {
        super("Account cannot be found!");
    }
}
