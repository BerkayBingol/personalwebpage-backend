package com.gokhantamkoc.personanlwebpage.backend.sessionservice.repository;

import com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
