package com.oosd.ecommerce.repository;

import com.oosd.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This defines the repository for the product entity.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(int id);
}
