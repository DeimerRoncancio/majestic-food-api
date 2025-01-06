package com.majestic.food.api.majestic_food_api.mappers;

import com.majestic.food.api.majestic_food_api.entities.Order;
import com.majestic.food.api.majestic_food_api.entities.Product;
import com.majestic.food.api.majestic_food_api.entities.dtos.NewOrderDTO;
import com.majestic.food.api.majestic_food_api.entities.dtos.UpdateOrderDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T21:22:41-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order orderCreateDTOtoOrder(NewOrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderName( dto.getOrderName() );
        order.setNotes( dto.getNotes() );
        order.setOrderDate( dto.getOrderDate() );
        order.setUser( dto.getUser() );

        return order;
    }

    @Override
    public void toUpdateOrder(UpdateOrderDTO dto, Order order) {
        if ( dto == null ) {
            return;
        }

        order.setOrderName( dto.getOrderName() );
        order.setNotes( dto.getNotes() );
        order.setOrderDate( dto.getOrderDate() );
        order.setUser( dto.getUser() );
        if ( order.getProduct() != null ) {
            List<Product> list = dto.getProduct();
            if ( list != null ) {
                order.getProduct().clear();
                order.getProduct().addAll( list );
            }
            else {
                order.setProduct( null );
            }
        }
        else {
            List<Product> list = dto.getProduct();
            if ( list != null ) {
                order.setProduct( new ArrayList<Product>( list ) );
            }
        }
    }
}
