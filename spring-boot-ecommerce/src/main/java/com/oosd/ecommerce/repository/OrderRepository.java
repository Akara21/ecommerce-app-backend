package com.oosd.ecommerce.repository;

import com.oosd.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This defines the repository for the order entity.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
