package com.majestic.food.api.majestic_food_api.mappers;

import com.majestic.food.api.majestic_food_api.auth.RegisterRequest;
import com.majestic.food.api.majestic_food_api.entities.Role;
import com.majestic.food.api.majestic_food_api.entities.User;
import com.majestic.food.api.majestic_food_api.entities.dtos.UserUpdateRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T21:22:41-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User userCreateDTOtoUser(RegisterRequest dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setName( dto.getName() );
        user.setProfileImage( dto.getProfileImage() );
        user.setSecondName( dto.getSecondName() );
        user.setLastnames( dto.getLastnames() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        user.setGender( dto.getGender() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        List<Role> list = dto.getRoles();
        if ( list != null ) {
            user.setRoles( new ArrayList<Role>( list ) );
        }
        user.setAdmin( dto.isAdmin() );

        return user;
    }

    @Override
    public void toUpdateUser(UserUpdateRequest dto, User user) {
        if ( dto == null ) {
            return;
        }

        user.setName( dto.getName() );
        user.setSecondName( dto.getSecondName() );
        user.setLastnames( dto.getLastnames() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        user.setGender( dto.getGender() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
        user.setAdmin( dto.isAdmin() );
    }
}
