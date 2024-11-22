package com.majestic.food.api.majestic_food_api.entities.dtos.auth;

import com.majestic.food.api.majestic_food_api.entities.User;

public class UserInfo {

    private String identifier;
    private User user;

    public UserInfo(String identifier, User user) {
        this.identifier = identifier;
        this.user = user;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}