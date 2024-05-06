package com.base.webSocket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "tblUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userNo", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long userNo;

    @Column(name = "userName", nullable = false)
    private String userName;

}
