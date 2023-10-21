package com.oosd.ecommerce.service.category;

import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import jdk.jfr.Category;

import java.util.List;

public interface CategoryService {
    List<ProductCategory> findAll();
    ProductCategory findById(int id);
    ProductCategory findByCategoryName(String name);
    List<Product> findProductsByCategoryId(int id);

}
