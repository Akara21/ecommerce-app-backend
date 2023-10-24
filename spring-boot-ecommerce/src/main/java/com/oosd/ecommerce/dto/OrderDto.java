package com.oosd.ecommerce.dto;

import com.oosd.ecommerce.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {
    private Long id;
    private List<OrderItem> orderItems;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
}
