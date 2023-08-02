package com.example.entity;

import com.example.enums.GeneralStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "company_name")
    private String CompanyName;
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private GeneralStatus status=GeneralStatus.ACTIVE;
    @Column(name = "created_date")
    private LocalDateTime createdDate=LocalDateTime.now();
}
