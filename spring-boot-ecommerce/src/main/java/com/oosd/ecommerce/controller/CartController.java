package com.oosd.ecommerce.controller;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    List<CartItemDto> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @PostMapping
    void addCartItem(@RequestBody CartItemDto cartItemDto) {
        cartService.addCartItem(cartItemDto);
    }

    @PostMapping("/delete")
    void removeCartItem(@RequestBody CartItemDto cartItemDto) {
        cartService.deleteCartItem(cartItemDto);
    }

    @PutMapping("/decreaseQuantity")
    void decreaseCartItemQuantity(@RequestBody CartItemDto cartItemDto) {
        cartService.decreaseCartItemQuantity(cartItemDto);
    }
}
