package com.base.webSocket.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "tblRoom")
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성 전략을 DB에 위임
    @Column(name = "roomNo", nullable = false)
    private Long roomNo;

    @Column(name = "roomName", nullable = false)
    private String roomName;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

}
