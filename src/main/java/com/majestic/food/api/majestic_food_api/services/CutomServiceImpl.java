package com.majestic.food.api.majestic_food_api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majestic.food.api.majestic_food_api.repositories.CustomRepository;

@Service
public class CutomServiceImpl implements CustomService {

    @Autowired
    private CustomRepository repository;

    @Override
    public Optional<?> findByCustomField(String entity, String fieldName, Object value) {
        return repository.findByCustomField(entity, fieldName, value);
    }

    @Override
    public Long ifExistsCustomField(String entity, String fieldName, Object value) {
        return repository.ifExistsCustomField(entity, fieldName, value);
    }
}