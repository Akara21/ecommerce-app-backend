package com.oosd.ecommerce.dao;

import com.oosd.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(int id);
}
