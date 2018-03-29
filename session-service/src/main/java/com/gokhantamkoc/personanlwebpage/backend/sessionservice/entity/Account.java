package com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gokhantamkoc.personanlwebpage.backend.sessionservice.annotations.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    @UUID
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private java.util.UUID id;

    @Column(name = "username", unique = true)
    @Size(max = 250)
    private String username;

    @Column(name = "password")
    @Size(max = 1000)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "email")
    @Size(max = 1000)
    private String email;
}
