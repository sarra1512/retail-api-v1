package com.retail.shop.retailapiv1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.shop.retailapiv1.models.Product;
import com.retail.shop.retailapiv1.repositories.ProductRepository;

@Service
public class RetailService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProduct(long id) {
		return productRepository.findById(id);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
}
