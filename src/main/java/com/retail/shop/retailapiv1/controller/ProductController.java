package com.retail.shop.retailapiv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.retail.shop.retailapiv1.models.Product;
import com.retail.shop.retailapiv1.services.RetailService;

import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private RetailService retailService;

	@Autowired
	Validator productValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(productValidator);
	}

	@PostMapping
	public Product create(@RequestBody @Valid Product product) {
		return retailService.saveProduct(product);
	}

	@GetMapping("/{id}")
	public Product view(@PathVariable("id") long id) {
		Optional<Product> product = retailService.getProduct(id);
		if (product.isEmpty()) {
			return null;
		}
		return product.get();
	}

	@PostMapping(value = "/{id}")
	public Product edit(@PathVariable("id") long id, @RequestBody @Valid Product product) {

		Optional<Product> updatedProduct = retailService.getProduct(id);

		if (updatedProduct.isEmpty()) {
			return null;
		}

		updatedProduct.get().setName(product.getName());
		updatedProduct.get().setPrice(product.getPrice());
		updatedProduct.get().setDescription(product.getDescription());

		return retailService.saveProduct(updatedProduct.get());
	}
	
	@DeleteMapping(value = "/{id}") 
	public String delete(@PathVariable("id") long id) {
		try {
			retailService.deleteProduct(id);
		} catch (Exception e) {
			return "Exception in delete";
		}
		
		return id+ " Deleted Successfully";
	}

}