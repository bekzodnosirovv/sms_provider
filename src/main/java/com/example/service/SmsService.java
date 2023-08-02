package com.example.service;

import com.example.dto.SmsDTO;
import com.example.dto.SmsRequestDTO;
import com.example.entity.SmsEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.SmsRepository;
import com.example.util.PhoneValidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Autowired
    private SmsRepository smsRepository;

    public boolean create(Integer clientId, SmsRequestDTO smsRequestDTO) {
        if (PhoneValidUtil.checkPhone(smsRequestDTO.getPhone())) {
            throw new AppBadRequestException("Phone number in valid");
        }
        SmsEntity entity = new SmsEntity();
        entity.setClientId(clientId);
        entity.setPhone(smsRequestDTO.getPhone());
        entity.setMessage(smsRequestDTO.getMessage());
        smsRepository.save(entity);
        return true;
    }

    public PageImpl<?> get(Integer clientId, int page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<SmsEntity> entityPage = smsRepository.findAllByClientId(clientId, pageable);
        return new PageImpl<>(entityPage.getContent().stream().map(this::toDTO).toList(), pageable, entityPage.getTotalElements());
    }

    private SmsDTO toDTO(SmsEntity entity) {
        SmsDTO dto = new SmsDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setMessage(entity.getMessage());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setClientId(entity.getClientId());
        return dto;
    }
}
