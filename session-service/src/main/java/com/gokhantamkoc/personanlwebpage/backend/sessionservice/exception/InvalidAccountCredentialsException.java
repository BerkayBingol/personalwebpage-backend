package com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception;

public class InvalidAccountCredentialsException extends Exception {

    public InvalidAccountCredentialsException() {
        super("Account credentials are invalid!");
    }
}
