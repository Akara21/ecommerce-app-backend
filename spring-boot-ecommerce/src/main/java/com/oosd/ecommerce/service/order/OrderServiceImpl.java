package com.oosd.ecommerce.service.order;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.dto.OrderDto;
import com.oosd.ecommerce.dto.OrderItemDto;
import com.oosd.ecommerce.entity.CartItem;
import com.oosd.ecommerce.entity.Order;
import com.oosd.ecommerce.entity.OrderItem;
import com.oosd.ecommerce.entity.User;
import com.oosd.ecommerce.mapper.CartMapper;
import com.oosd.ecommerce.mapper.OrderMapper;
import com.oosd.ecommerce.repository.OrderRepository;
import com.oosd.ecommerce.service.auth.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final UserService userService;
    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public void addOrder(List<OrderItemDto> orderItemDtoList) {
        System.out.println("ORDER ITEMS " + orderItemDtoList);
        User user = userService.getCurrentUser();
        Order order = new Order();

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDto orderItemDto : orderItemDtoList) {
            OrderItem orderItem = OrderMapper.map(orderItemDto);
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }

        BigDecimal totalAmount = calculateTotalAmount(orderItems);
        LocalDateTime orderDate = LocalDateTime.now();

        System.out.println("ORDER ITEMS NEW: " + orderItems);

        order.setUser(user);
        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(orderDate);

        orderRepository.save(order);

        user.addOrder(order);

        userService.save(user);

    }

    @Override
    public List<OrderDto> getOrders() {
        User user = userService.getCurrentUser();
        List<OrderDto> orderDtoList = new ArrayList<>();

        for (Order order: user.getOrders()) {
            orderDtoList.add(OrderMapper.map(order));
        }
        return orderDtoList;
    }

    public BigDecimal calculateTotalAmount(List<OrderItem> orderItems) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderItem orderItem : orderItems) {
            BigDecimal itemTotal = orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()));
            System.out.println("Order Item " + orderItem);
            System.out.println("Total bis jetzt: " + totalAmount);
            totalAmount = totalAmount.add(itemTotal);
        }

        return totalAmount;
    }
}
