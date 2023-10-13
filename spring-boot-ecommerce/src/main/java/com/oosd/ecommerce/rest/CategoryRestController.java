package com.oosd.ecommerce.rest;

import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import com.oosd.ecommerce.service.CategoryServiceImpl;
import com.oosd.ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryRestController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryRestController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<ProductCategory> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ProductCategory getProductCategoryById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @GetMapping("/byName")
    public ProductCategory getProductByCategoryName(@RequestParam String name) {
        return categoryService.findByCategoryName(name);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategoryId(@PathVariable int id) {
        return categoryService.findProductsByCategoryId(id);
    }
}
