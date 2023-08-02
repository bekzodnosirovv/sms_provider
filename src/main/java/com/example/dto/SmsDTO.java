package com.example.dto;

import com.example.entity.ClientEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsDTO {

    private String id;
    private Integer clientId;
    private ClientEntity client;
    private String phone;
    private String message;
    private LocalDateTime createdDate;
}
