package com.oosd.ecommerce.controller;

import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.service.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    private ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product, @RequestParam("categoryName") String categoryName) {
        Product createdProduct = productService.save(product, categoryName);
        return createdProduct;
    }

}
