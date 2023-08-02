package com.example.repository;

import com.example.entity.SmsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SmsRepository extends CrudRepository<SmsEntity, String>,
        PagingAndSortingRepository<SmsEntity, String> {
    Page<SmsEntity> findAllByClientId(Integer clientId, Pageable pageable);
}
