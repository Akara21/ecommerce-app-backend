package com.oosd.ecommerce.mapper;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.dto.OrderDto;
import com.oosd.ecommerce.dto.OrderItemDto;
import com.oosd.ecommerce.entity.CartItem;
import com.oosd.ecommerce.entity.Order;
import com.oosd.ecommerce.entity.OrderItem;

/**
 * This provides helper functions for mapping an order item object to an order item dto object and vice versa.
 * This also provides helper functions for mapping an order object to an order dto object and vice versa.
 */
public class OrderMapper {

    public static OrderItem map(OrderItemDto orderItemDto) {
        return OrderItem.builder()
                .product(orderItemDto.getProduct())
                .quantity(orderItemDto.getQuantity())
                .build();
    }

    public static OrderItemDto map(OrderItem orderItem) {
        return OrderItemDto.builder()
                .product(orderItem.getProduct())
                .quantity(orderItem.getQuantity())
                .build();
    }

    public static Order map(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .orderItems(orderDto.getOrderItems())
                .totalAmount(orderDto.getTotalAmount())
                .orderDate(orderDto.getOrderDate())
                .build();
    }

    public static OrderDto map(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .orderItems(order.getOrderItems())
                .totalAmount(order.getTotalAmount())
                .orderDate(order.getOrderDate())
                .build();
    }
}
