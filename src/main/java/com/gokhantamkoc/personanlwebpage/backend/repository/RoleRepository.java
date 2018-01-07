package com.gokhantamkoc.personanlwebpage.backend.repository;

import com.gokhantamkoc.personanlwebpage.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
