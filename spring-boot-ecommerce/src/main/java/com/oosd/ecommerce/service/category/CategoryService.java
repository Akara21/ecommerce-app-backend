package com.oosd.ecommerce.service.category;

import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import jdk.jfr.Category;

import java.util.List;

/**
 * This defines the interface of the category service for managing the category entity.
 */
public interface CategoryService {

    List<ProductCategory> findAll();
    ProductCategory findById(int id);
    List<Product> findProductsByCategoryId(int id);

}
