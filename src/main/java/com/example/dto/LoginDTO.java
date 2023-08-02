package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {
    @NotNull(message = "Login is required")
    @Size(min = 5, message = "Login should be at least 5 characters")
    @NotBlank(message = "Field must have some value")
    private String login;
    @NotNull(message = "Password is required")
    @Size(min = 5, message = "Password should be at least 5 characters")
    @NotBlank(message = "Field must have some value")
    private String password;
}
