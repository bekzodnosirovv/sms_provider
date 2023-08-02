package com.example.service;

import com.example.dto.ClientDTO;
import com.example.entity.ClientEntity;
import com.example.enums.GeneralStatus;
import com.example.exp.AppBadRequestException;
import com.example.exp.ItemNotFoundException;
import com.example.repository.ClientRepository;
import com.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    public ClientDTO create(ClientDTO clientDTO) {
        ClientEntity entity = new ClientEntity();
        entity.setCompanyName(clientDTO.getCompanyName());
        entity.setLogin(clientDTO.getLogin());
        entity.setPassword(MD5Util.encode(clientDTO.getPassword()));
        clientRepository.save(entity);
        clientDTO.setId(entity.getId());
        return clientDTO;
    }

    public PageImpl<ClientDTO> get(int page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<ClientEntity> entityPage = clientRepository.findAll(pageable);
        return new PageImpl<>(entityPage.getContent().stream().map(this::toDTO).toList(), pageable, entityPage.getTotalElements());
    }

    private ClientDTO toDTO(ClientEntity entity) {
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setCompanyName(entity.getCompanyName());
        dto.setStatus(entity.getStatus());
        dto.setPassword(entity.getPassword());
        dto.setLogin(entity.getLogin());
        return dto;
    }

    public ClientDTO update(Integer id) {
        Optional<ClientEntity> optional = clientRepository.findById(id);
        if (optional.isEmpty()) throw new ItemNotFoundException("Client not found");
        ClientEntity entity = optional.get();
        entity.setStatus(GeneralStatus.BLOCK);
        clientRepository.save(entity);
        return toDTO(entity);
    }
}
