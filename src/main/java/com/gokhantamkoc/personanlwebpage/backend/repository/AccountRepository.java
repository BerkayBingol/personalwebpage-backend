package com.gokhantamkoc.personanlwebpage.backend.repository;

import com.gokhantamkoc.personanlwebpage.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("select a from Account a where a.username=:username")
    Account findAccountByUsername(@Param("username") String username);
}
