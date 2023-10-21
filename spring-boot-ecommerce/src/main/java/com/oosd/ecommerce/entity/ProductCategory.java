package com.oosd.ecommerce.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductCategory() {}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public int getAmountOfProducts() {
        return this.products.size();
    }

    public void addProduct(Product product) {
        if (products == null) {
            products = new HashSet<>();
        }

        products.add(product);
        product.setCategory(this);
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}


