package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SmsRequestDTO {
    @NotNull(message = "Phone is required")
    private String phone;
    @NotNull(message = "Message is required")
    @NotBlank(message = "Field must have some value")
    private String message;
}
