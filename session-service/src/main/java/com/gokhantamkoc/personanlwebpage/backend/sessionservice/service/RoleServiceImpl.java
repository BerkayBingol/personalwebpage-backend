package com.gokhantamkoc.personanlwebpage.backend.sessionservice.service;

import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Role;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleRepository roleRepository;

    @Override
    public List<Role> list() {
        return null;
    }

    @Override
    public Role create(Role role) {
        return null;
    }

    @Override
    public Role update(Role role) {
        return null;
    }
}
