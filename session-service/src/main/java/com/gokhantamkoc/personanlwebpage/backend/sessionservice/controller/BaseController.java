package com.gokhantamkoc.personanlwebpage.backend.sessionservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected final Logger LOGGER = LoggerFactory.getLogger("Application");

    protected final int BAD_REQUEST_STATUS_CODE = HttpStatus.BAD_REQUEST.value();
    protected final int OK_STATUS_CODE = HttpStatus.OK.value();

    protected final ResponseEntity<?> generateErrorResponse(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return new ResponseEntity<>(new Response(BAD_REQUEST_STATUS_CODE, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    protected final ResponseEntity<?> generateSuccessResponse(String message) {
        return new ResponseEntity<>(new Response(OK_STATUS_CODE, message), HttpStatus.OK);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Response {
        private int status;
        private String message;
    }
}
