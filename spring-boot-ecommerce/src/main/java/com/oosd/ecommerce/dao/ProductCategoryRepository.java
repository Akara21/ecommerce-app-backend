package com.oosd.ecommerce.dao;

import com.oosd.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "categories")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
