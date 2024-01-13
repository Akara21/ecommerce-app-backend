package com.oosd.ecommerce.controller;

import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import com.oosd.ecommerce.service.category.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This provides the API-endpoints for the category functionality.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @GetMapping
    public List<ProductCategory> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ProductCategory getProductCategoryById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategoryId(@PathVariable int id) {
        return categoryService.findProductsByCategoryId(id);
    }

}
