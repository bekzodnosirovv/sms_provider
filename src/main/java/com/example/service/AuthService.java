package com.example.service;

import com.example.dto.LoginDTO;
import com.example.dto.ProfileDTO;
import com.example.entity.ClientEntity;
import com.example.entity.ProfileEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.ClientRepository;
import com.example.repository.ProfileRepository;
import com.example.util.JWTUtil;
import com.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProfileRepository profileRepository;


    public String loginClient(LoginDTO loginDTO) {
        Optional<ClientEntity> optional = clientRepository.getByLogin(loginDTO.getLogin());
        if (optional.isEmpty()) {
            throw new AppBadRequestException("You are not registration");
        } else {
            if (!optional.get().getPassword().equals(MD5Util.encode(loginDTO.getPassword()))) {
                throw new AppBadRequestException("Password or login error");
            }
        }
        return JWTUtil.encode(optional.get().getId());
    }

    public ProfileDTO loginProfile(LoginDTO loginDTO) {
        Optional<ProfileEntity> optional = profileRepository.getByLoginAndPassword(loginDTO.getLogin(), loginDTO.getPassword());
        if (optional.isEmpty()) {
            throw new AppBadRequestException("You are not registration");
        } else {
            if (optional.get().getPassword().equals(MD5Util.encode(loginDTO.getPassword()))) {
                throw new AppBadRequestException("Password or login error");
            }
        }
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setName(optional.get().getName());
        profileDTO.setSurname(optional.get().getSurname());
        profileDTO.setStatus(optional.get().getStatus());
        return profileDTO;
    }
}
