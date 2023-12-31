package com.oosd.ecommerce.service;

import com.oosd.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product, String categoryName);

}
