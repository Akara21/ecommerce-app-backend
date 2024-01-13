package com.oosd.ecommerce.mapper;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.entity.CartItem;

/**
 * This provides helper functions for mapping a cart item object to a cart item dto object and vice versa.
 */
public class CartMapper
{
    public static CartItem map(CartItemDto cartItemDto) {
        return CartItem.builder()
                .product(cartItemDto.getProduct())
                .quantity(cartItemDto.getQuantity())
                .build();
    }

    public static CartItemDto map(CartItem cartItem) {
        return CartItemDto.builder()
                .product(cartItem.getProduct())
                .quantity(cartItem.getQuantity())
                .build();
    }
}
