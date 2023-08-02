package com.example.dto;

import com.example.enums.GeneralStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {
    private Integer id;
    @NotNull(message = "Company name is required")
    @NotBlank(message = "Field must have some value")
    private String CompanyName;
    @NotNull(message = "Login is required")
    @Size(min = 5, message = "Login should be at least 5 characters")
    @NotBlank(message = "Field must have some value")
    private String login;
    @NotNull(message = "Password is required")
    @Size(min = 5, message = "Password should be at least 5 characters")
    @NotBlank(message = "Field must have some value")
    private String password;
    private GeneralStatus status;
    private LocalDateTime createdDate;
}
