package com.gokhantamkoc.personanlwebpage.backend.sessionservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session")
@Getter
@Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

<<<<<<< HEAD:src/main/java/com/gokhantamkoc/personanlwebpage/backend/entity/Session.java
=======
    @Column(name = "token")
>>>>>>> master:session-service/src/main/java/com/gokhantamkoc/personanlwebpage/backend/sessionservice/entity/Session.java
    private java.util.UUID token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expire_date")
    private Date expireDate;
}
