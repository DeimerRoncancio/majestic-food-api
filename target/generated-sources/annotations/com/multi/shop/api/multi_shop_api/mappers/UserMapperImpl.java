package com.multi.shop.api.multi_shop_api.mappers;

import com.multi.shop.api.multi_shop_api.auth.RegisterRequest;
import com.multi.shop.api.multi_shop_api.entities.Role;
import com.multi.shop.api.multi_shop_api.entities.User;
import com.multi.shop.api.multi_shop_api.entities.dtos.UserUpdateRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-13T17:48:06-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User userCreateDTOtoUser(RegisterRequest dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setAdmin( dto.isAdmin() );
        user.setEmail( dto.getEmail() );
        user.setGender( dto.getGender() );
        user.setLastnames( dto.getLastnames() );
        user.setName( dto.getName() );
        user.setPassword( dto.getPassword() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        List<Role> list = dto.getRoles();
        if ( list != null ) {
            user.setRoles( new ArrayList<Role>( list ) );
        }
        user.setSecondName( dto.getSecondName() );

        return user;
    }

    @Override
    public void toUpdateUser(UserUpdateRequest dto, User user) {
        if ( dto == null ) {
            return;
        }

        user.setAdmin( dto.isAdmin() );
        user.setEmail( dto.getEmail() );
        user.setGender( dto.getGender() );
        user.setLastnames( dto.getLastnames() );
        user.setName( dto.getName() );
        user.setPassword( dto.getPassword() );
        user.setPhoneNumber( dto.getPhoneNumber() );
        user.setSecondName( dto.getSecondName() );
    }
}
