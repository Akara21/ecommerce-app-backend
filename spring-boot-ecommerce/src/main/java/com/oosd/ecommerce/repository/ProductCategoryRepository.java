package com.oosd.ecommerce.repository;

import com.oosd.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This defines the repository for the category entity.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    Optional<ProductCategory> findByCategoryName(String name);
}
