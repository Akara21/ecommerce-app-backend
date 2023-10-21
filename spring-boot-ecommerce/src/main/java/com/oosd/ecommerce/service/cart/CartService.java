package com.oosd.ecommerce.service.cart;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.entity.CartItem;

import java.util.List;

public interface CartService {

    List<CartItemDto> getAllCartItems();
    void addCartItem(CartItemDto cartItemDto);
    void deleteCartItem(CartItemDto cartItemDto);

    void decreaseCartItemQuantity(CartItemDto cartItemDto);


}
