package com.oosd.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * This defines the structure of a product.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private BigDecimal price;

    @Column(name = "image_url")
    private String imageUrl;

    private String material;

    private int weight;

    @Column(name = "comfort_duration")
    private int comfortDuration;

    @Column(name = "usage_area")
    private String usageArea;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

}
