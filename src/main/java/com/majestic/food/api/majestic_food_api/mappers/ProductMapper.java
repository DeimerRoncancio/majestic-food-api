package com.majestic.food.api.majestic_food_api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.majestic.food.api.majestic_food_api.entities.Product;
import com.majestic.food.api.majestic_food_api.entities.dtos.NewProductDTO;
import com.majestic.food.api.majestic_food_api.entities.dtos.UpdateProductDTO;

@Mapper
public interface ProductMapper {

    ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "id", ignore = true)
    Product productCreateDTOtoProduct(NewProductDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "categories", ignore = true)
    void toUpdateProduct(UpdateProductDTO dto, @MappingTarget Product product);
}
