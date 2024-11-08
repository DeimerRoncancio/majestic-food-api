package com.majestic.food.api.majestic_food_api.services;

import com.majestic.food.api.majestic_food_api.entities.ProductCategory;
import com.majestic.food.api.majestic_food_api.repositories.ProductCategoryRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductCategory> findOne(String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public ProductCategory save(ProductCategory category) {
        return repository.save(category);
    }

    @Override
    @Transactional
    public Optional<ProductCategory> update(String id, ProductCategory category) {
        Optional<ProductCategory> optionalCategory = repository.findById(id);
        
        optionalCategory.ifPresent(categoryDb -> {
            categoryDb.setCategoryName(category.getCategoryName());

            repository.save(categoryDb);
        });

        return optionalCategory;
    }

    @Override
    @Transactional
    public Optional<ProductCategory> delete(String id) {
        Optional<ProductCategory> optionalCategory = repository.findById(id);

        if (optionalCategory.isPresent())
            repository.delete(optionalCategory.get());
        
        return optionalCategory;
    }
}
