package com.gokhantamkoc.personanlwebpage.backend.exception;

public class InvalidTokenException extends Exception {
    public InvalidTokenException() {
        super("Security token is invalid!");
    }
}
