package com.gokhantamkoc.personanlwebpage.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "Personal Web Page - Backend v1.0.0 - Gökhan TAMKOÇ";
    }
}
