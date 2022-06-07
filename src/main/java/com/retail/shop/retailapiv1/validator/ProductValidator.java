package com.retail.shop.retailapiv1.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.retail.shop.retailapiv1.models.Product;

public class ProductValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.required");

        Product product = (Product) o;

        if( product.getName().isEmpty() ){
            errors.rejectValue("Name", "Name.required");
        }
        if( product.getPrice().isEmpty() ){
            errors.rejectValue("Price", "Price.required");
        }

    }
}
