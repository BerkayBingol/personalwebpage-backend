package com.gokhantamkoc.personanlwebpage.backend.entity;

import com.gokhantamkoc.personanlwebpage.backend.annotations.UUID;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "article")
@Getter
@Setter
public class Article {

    @Id
    @UUID
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private java.util.UUID id;

    @Column(name = "title")
    @Size(max = 250)
    private String title;

    @Column(name = "content")
    @Type(type = "text")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
}
