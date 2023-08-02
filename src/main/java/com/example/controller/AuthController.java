package com.example.controller;

import com.example.dto.LoginDTO;
import com.example.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/")
    public ResponseEntity<?> loginClient(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.loginClient(loginDTO));
    }

    @PostMapping("")
    public ResponseEntity<?> loginProfile(@Valid @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.loginProfile(loginDTO));
    }
}
