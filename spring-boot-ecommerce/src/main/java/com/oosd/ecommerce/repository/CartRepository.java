package com.oosd.ecommerce.repository;

import com.oosd.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
