package com.gokhantamkoc.personanlwebpage.backend.articleservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected final Logger LOGGER = LoggerFactory.getLogger("Application");

    protected final ResponseEntity<?> generateError(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
    }
}
