package com.oosd.ecommerce.mapper;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.dto.OrderDto;
import com.oosd.ecommerce.dto.OrderItemDto;
import com.oosd.ecommerce.entity.CartItem;
import com.oosd.ecommerce.entity.Order;
import com.oosd.ecommerce.entity.OrderItem;

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
                .orderItems(orderDto.getOrderItems())
                .totalAmount(orderDto.getTotalAmount())
                .orderDate(orderDto.getOrderDate())
                .build();
    }

    public static OrderDto map(Order order) {
        return OrderDto.builder()
                .orderItems(order.getOrderItems())
                .totalAmount(order.getTotalAmount())
                .orderDate(order.getOrderDate())
                .build();
    }
}
