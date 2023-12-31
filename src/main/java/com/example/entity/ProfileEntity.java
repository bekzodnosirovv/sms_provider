package com.example.entity;

import com.example.enums.GeneralStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private GeneralStatus status;
    @Column(name = "created_date")
    private LocalDateTime createdDate=LocalDateTime.now();

}
