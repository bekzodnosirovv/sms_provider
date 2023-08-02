package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sms")
public class SmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "client_id")
    private Integer clientId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private ClientEntity client;
    @Column(name = "phone")
    private String phone;
    @Column(columnDefinition = "Text")
    private String message;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();
}
