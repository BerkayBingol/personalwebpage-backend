package com.gokhantamkoc.personanlwebpage.backend.exception;

public class InvalidAccountException extends Exception {
    public InvalidAccountException() {
        super("The account information is invalid!");
    }
}
