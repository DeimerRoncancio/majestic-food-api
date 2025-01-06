package com.majestic.food.api.majestic_food_api.mappers;

import com.majestic.food.api.majestic_food_api.entities.Image;
import com.majestic.food.api.majestic_food_api.entities.Product;
import com.majestic.food.api.majestic_food_api.entities.ProductCategory;
import com.majestic.food.api.majestic_food_api.entities.dtos.NewProductDTO;
import com.majestic.food.api.majestic_food_api.entities.dtos.UpdateProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T21:44:51-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productCreateDTOtoProduct(NewProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductName( dto.getProductName() );
        product.setDescription( dto.getDescription() );
        product.setPrice( dto.getPrice() );
        List<ProductCategory> list = dto.getCategories();
        if ( list != null ) {
            product.setCategories( new ArrayList<ProductCategory>( list ) );
        }
        List<Image> list1 = dto.getImages();
        if ( list1 != null ) {
            product.setImages( new ArrayList<Image>( list1 ) );
        }

        return product;
    }

    @Override
    public void toUpdateProduct(UpdateProductDTO dto, Product product) {
        if ( dto == null ) {
            return;
        }

        product.setProductName( dto.getProductName() );
        product.setDescription( dto.getDescription() );
        product.setPrice( dto.getPrice() );
    }
}
