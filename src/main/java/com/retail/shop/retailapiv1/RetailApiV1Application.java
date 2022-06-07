package com.retail.shop.retailapiv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;

import com.retail.shop.retailapiv1.validator.ProductValidator;

@SpringBootApplication
public class RetailApiV1Application {

	public static void main(String[] args) {
		SpringApplication.run(RetailApiV1Application.class, args);
	}
	
	@Bean
	public Validator productValidator() {
		return new ProductValidator();
	}

}
