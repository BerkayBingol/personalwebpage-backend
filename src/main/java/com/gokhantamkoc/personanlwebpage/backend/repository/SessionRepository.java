package com.gokhantamkoc.personanlwebpage.backend.repository;

import com.gokhantamkoc.personanlwebpage.backend.entity.Account;
import com.gokhantamkoc.personanlwebpage.backend.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query(value = "select s from Session s where s.account=:account")
    Session findSessionByAccount(@Param("account") Account account);

    @Query(value = "select s from Session s where s.token=:token")
    Session findSessionByToken(@Param("token") String token);
}
