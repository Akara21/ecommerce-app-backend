package com.oosd.ecommerce.service.order;

import com.oosd.ecommerce.dto.OrderDto;
import com.oosd.ecommerce.dto.OrderItemDto;
import com.oosd.ecommerce.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    void addOrder(List<OrderItemDto> orders);
    List<OrderDto> getOrders();
}
