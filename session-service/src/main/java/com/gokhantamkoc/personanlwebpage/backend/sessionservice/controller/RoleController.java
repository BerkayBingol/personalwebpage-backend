package com.gokhantamkoc.personanlwebpage.backend.sessionservice.controller;

import com.gokhantamkoc.personanlwebpage.backend.sessionservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> list() {
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<?> update() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    public ResponseEntity<?> create() {
        return null;
    }
}
