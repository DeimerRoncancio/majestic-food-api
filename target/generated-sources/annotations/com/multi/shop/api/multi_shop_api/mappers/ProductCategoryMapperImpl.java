package com.multi.shop.api.multi_shop_api.mappers;

import com.multi.shop.api.multi_shop_api.entities.ProductCategory;
import com.multi.shop.api.multi_shop_api.entities.dtos.NewProductCategoryDTO;
import com.multi.shop.api.multi_shop_api.entities.dtos.UpdateProductCategoryDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-17T19:40:17-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
public class ProductCategoryMapperImpl implements ProductCategoryMapper {

    @Override
    public ProductCategory categoryCreateDTOtoCategory(NewProductCategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName( dto.getCategoryName() );

        return productCategory;
    }

    @Override
    public void toUpdateCategory(UpdateProductCategoryDTO dto, ProductCategory category) {
        if ( dto == null ) {
            return;
        }

        category.setCategoryName( dto.getCategoryName() );
    }
}
