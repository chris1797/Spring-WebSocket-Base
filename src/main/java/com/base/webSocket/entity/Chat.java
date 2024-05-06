package com.base.webSocket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long chatNo;

    @ManyToOne(targetEntity = Room.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "roomNo")
    private Long roomNo;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo")
    private Long userNo;

    private String message;
}
