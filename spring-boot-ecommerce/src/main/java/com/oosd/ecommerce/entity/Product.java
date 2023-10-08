package com.oosd.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

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
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    public Product
            (String name,
             String description,
             BigDecimal price,
             String imageUrl,
             String material,
             int weight,
             int comfortDuration,
             String usageArea) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.material = material;
        this.weight = weight;
        this.comfortDuration = comfortDuration;
        this.usageArea = usageArea;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getComfortDuration() {
        return comfortDuration;
    }

    public void setComfortDuration(int comfortDuration) {
        this.comfortDuration = comfortDuration;
    }

    public String getUsageArea() {
        return usageArea;
    }

    public void setUsageArea(String usageArea) {
        this.usageArea = usageArea;
    }

    public ProductCategory getProductCategory() {
        return category;
    }

    public void setProductCategory(ProductCategory category) {
        this.category = category;
    }
}
