package com.example.controller;

import com.example.dto.ClientDTO;
import com.example.service.ClientService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.create(clientDTO));
    }

    @GetMapping("/page")
    public ResponseEntity<?> get(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(clientService.get(page - 1, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id){
        return ResponseEntity.ok(clientService.update(id));
    }
}
