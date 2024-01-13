package com.oosd.ecommerce.service.cart;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.entity.CartItem;

import java.util.List;

/**
 * This defines the interface of the cart service for managing the category item entity.
 */
public interface CartService {

    List<CartItemDto> getAllCartItems();
    void addCartItem(CartItemDto cartItemDto);
    void deleteCartItem(CartItemDto cartItemDto);
    void decreaseCartItemQuantity(CartItemDto cartItemDto);
    void clearCart();

}
