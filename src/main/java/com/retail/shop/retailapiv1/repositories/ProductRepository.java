package com.retail.shop.retailapiv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.shop.retailapiv1.models.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

}