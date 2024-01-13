package com.oosd.ecommerce.repository;

import com.oosd.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This defines the repository for the cart item entity.
 */
public interface CartRepository extends JpaRepository<CartItem, Long> {
}
