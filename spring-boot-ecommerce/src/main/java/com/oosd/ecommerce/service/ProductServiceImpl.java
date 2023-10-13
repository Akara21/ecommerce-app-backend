package com.oosd.ecommerce.service;

import com.oosd.ecommerce.dao.ProductCategoryRepository;
import com.oosd.ecommerce.dao.ProductRepository;
import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import com.oosd.ecommerce.exception.CategoryExceptionHandling.CategoryNotFoundException;
import com.oosd.ecommerce.exception.ProductExceptionHandling.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }

    @Override
    @Transactional
    public Product save(Product product, String categoryName) {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findByCategoryName(categoryName);

        if (optionalProductCategory.isPresent()) {
            ProductCategory productCategory = optionalProductCategory.get();
            productCategory.addProduct(product);
            productCategoryRepository.save(productCategory);
            return product;
        } else {
            throw new CategoryNotFoundException("Product with name " + categoryName + " not found");
        }
    }
}
