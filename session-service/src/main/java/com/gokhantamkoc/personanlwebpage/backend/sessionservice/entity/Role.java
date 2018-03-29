package com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(max = 250)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Account> accounts;
}
