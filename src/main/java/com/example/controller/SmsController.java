package com.example.controller;

import com.example.dto.SmsRequestDTO;
import com.example.service.SmsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody SmsRequestDTO smsRequestDTO,
                                              HttpServletRequest request) {
        Integer clientId = (Integer) request.getAttribute("id");
        return ResponseEntity.ok(smsService.create(clientId, smsRequestDTO));
    }

    @GetMapping("get")
    public ResponseEntity<?> get(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size,
                                 HttpServletRequest request) {
        Integer clientId = (Integer) request.getAttribute("id");
        return ResponseEntity.ok(smsService.get(clientId,page-1,size));
    }

}
