package com.oosd.ecommerce.service.category;

import com.oosd.ecommerce.repository.ProductCategoryRepository;
import com.oosd.ecommerce.repository.ProductRepository;
import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import com.oosd.ecommerce.error.CategoryExceptionHandling.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This defines the implementation of the category service for managing the category entity.
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private ProductCategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> productCategories = categoryRepository.findAll();
        return productCategories;
    }

    @Override
    public ProductCategory findById(int id) {
        Optional<ProductCategory> optionalProductCategory = categoryRepository.findById(id);
        if (optionalProductCategory.isPresent()) {
            return optionalProductCategory.get();
        } else {
            throw new CategoryNotFoundException("Product with id " + id + " not found");
        }
    }

    @Override
    public List<Product> findProductsByCategoryId(int id) {
        List<Product> products = productRepository.findByCategoryId(id);
        return products;
    }
}
