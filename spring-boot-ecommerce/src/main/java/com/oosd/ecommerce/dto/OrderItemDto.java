package com.oosd.ecommerce.dto;

import com.oosd.ecommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItemDto {
    private Product product;
    private int quantity;
}
