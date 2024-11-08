package com.majestic.food.api.majestic_food_api.validation;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class SizeConstraintValidation implements ConstraintValidator<SizeConstraint, String>{

    private int min;
    private int max;
    
    @Override
    public void initialize(SizeConstraint anotation) {
        this.min = anotation.min();
        this.max = anotation.max();
    }
    
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return !password.isBlank() ? (password.length() >= min && password.length() <= max) : true;
    }
}
