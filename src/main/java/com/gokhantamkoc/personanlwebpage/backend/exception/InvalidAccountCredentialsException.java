package com.gokhantamkoc.personanlwebpage.backend.exception;

public class InvalidAccountCredentialsException extends Exception {

    public InvalidAccountCredentialsException() {
        super("Account credentials are invalid!");
    }
}
