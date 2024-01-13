package com.oosd.ecommerce.service.order;

import com.oosd.ecommerce.dto.OrderDto;
import com.oosd.ecommerce.dto.OrderItemDto;
import com.oosd.ecommerce.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This defines the interface of the order service for managing the order entity and order item entity.
 */
public interface OrderService {

    void addOrder(List<OrderItemDto> orders);
    List<OrderDto> getOrders();
}
