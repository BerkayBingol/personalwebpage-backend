package com.gokhantamkoc.personanlwebpage.backend.sessionservice.exception;

public class InvalidTokenException extends Exception {
    public InvalidTokenException() {
        super("Security token is invalid!");
    }
}
