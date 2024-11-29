package com.majestic.food.api.majestic_food_api.services;

import com.majestic.food.api.majestic_food_api.entities.Image;
import com.majestic.food.api.majestic_food_api.entities.Product;
import com.majestic.food.api.majestic_food_api.entities.ProductCategory;
import com.majestic.food.api.majestic_food_api.entities.dtos.NewProductDTO;
import com.majestic.food.api.majestic_food_api.entities.dtos.UpdateProductDTO;
import com.majestic.food.api.majestic_food_api.mappers.ProductMapper;
import com.majestic.food.api.majestic_food_api.repositories.ProductCategoryRepository;
import com.majestic.food.api.majestic_food_api.repositories.ProductRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository repository;
    private final ProductCategoryRepository categoryRepository;
    private final ImageService imageService;

    public ProductServiceImpl(ProductRepository repository, ProductCategoryRepository categoryRepository, ImageService imageService) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.imageService = imageService;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findOne(String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Product save(NewProductDTO dto, List<MultipartFile> files) {
        List<ProductCategory> categoryList =  categoryRepository.findByCategoryNameIn(dto.getCategoriesList());
        dto.setCategories(categoryList);
        
        files.forEach(img -> {
            Image image = uploadProductImage(img);
            dto.getImages().add(image);
        });
        
        Product product = ProductMapper.mapper.productCreateDTOtoProduct(dto);

        return repository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> update(String id, UpdateProductDTO dto) {
        Optional<Product> productOptional = repository.findById(id);

        productOptional.ifPresent(productDb -> {
            ProductMapper.mapper.toUpdateProduct(dto, productDb);

            repository.save(productDb);
        });

        return productOptional;
    }

    @Override
    @Transactional
    public Optional<Product> delete(String id) {
        Optional<Product> productOptional = repository.findById(id);

        if (productOptional.isPresent())
            repository.delete(productOptional.get());
        
        return productOptional;
    }
    
    public Image uploadProductImage(MultipartFile file) {
        Image image = null;

        if (file != null && !file.isEmpty()) {
            try {
                image = imageService.uploadImage(file);
            } catch (IOException e) {
                logger.error("Exception to try add the image: " + e);
            }
        }

        return image;
    }
}
