package com.example.repository;

import com.example.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer>,
        PagingAndSortingRepository<ClientEntity, Integer> {

    Optional<ClientEntity> getByLogin(String login);

}
