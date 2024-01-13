package com.oosd.ecommerce.service.product;

import com.oosd.ecommerce.entity.Product;

import java.util.List;

/**
 * This defines the interface of the product service for managing the product entity.
 */
public interface ProductService {
    List<Product> findAll();
    Product findById(int id);

}
