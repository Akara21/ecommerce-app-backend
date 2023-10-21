package com.oosd.ecommerce.service.category;

import com.oosd.ecommerce.dao.ProductCategoryRepository;
import com.oosd.ecommerce.dao.ProductRepository;
import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import com.oosd.ecommerce.exception.CategoryExceptionHandling.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private ProductCategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(ProductCategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> productCategories = categoryRepository.findAll();
        System.out.println("Categories: " + productCategories);
        return productCategories;
    }

    @Override
    public ProductCategory findById(int id) {
        Optional<ProductCategory> optionalProductCategory = categoryRepository.findById(id);

        if (optionalProductCategory.isPresent()) {
            System.out.println("Category: " + optionalProductCategory.get());
            return optionalProductCategory.get();
        } else {
            throw new CategoryNotFoundException("Product with id " + id + " not found");
        }

    }

    @Override
    public ProductCategory findByCategoryName(String name) {
        Optional<ProductCategory> optionalProductCategory = categoryRepository.findByCategoryName(name);

        if (optionalProductCategory.isPresent()) {
            System.out.println("Category: " + optionalProductCategory.get());
            return optionalProductCategory.get();
        } else {
            throw new CategoryNotFoundException("Product with name " + name + " not found");
        }
    }

    @Override
    public List<Product> findProductsByCategoryId(int id) {
        List<Product> products = productRepository.findByCategoryId(id);
        return products;
    }
}
