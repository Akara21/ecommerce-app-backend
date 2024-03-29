package com.oosd.ecommerce.controller;

import com.oosd.ecommerce.dto.OrderDto;
import com.oosd.ecommerce.dto.OrderItemDto;
import com.oosd.ecommerce.entity.Order;
import com.oosd.ecommerce.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This provides the API-endpoints for the order functionality.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    void addOrder(@RequestBody List<OrderItemDto> orderItemDtoList) {
        orderService.addOrder(orderItemDtoList);
    }

}
