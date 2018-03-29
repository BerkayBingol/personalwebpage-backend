package com.gokhantamkoc.personanlwebpage.backend.sessionservice.service;

import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> list();
    Role create(Role role);
    Role update(Role role);
}
