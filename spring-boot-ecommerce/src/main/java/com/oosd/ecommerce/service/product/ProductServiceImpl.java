package com.oosd.ecommerce.service.product;

import com.oosd.ecommerce.repository.ProductCategoryRepository;
import com.oosd.ecommerce.repository.ProductRepository;
import com.oosd.ecommerce.entity.Product;
import com.oosd.ecommerce.entity.ProductCategory;
import com.oosd.ecommerce.error.CategoryExceptionHandling.CategoryNotFoundException;
import com.oosd.ecommerce.error.ProductExceptionHandling.ProductNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This defines the implementation of the product service for managing the product entity.
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

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

}
