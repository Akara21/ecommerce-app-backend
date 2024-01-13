package com.oosd.ecommerce.service.cart;

import com.oosd.ecommerce.dto.CartItemDto;
import com.oosd.ecommerce.entity.CartItem;
import com.oosd.ecommerce.entity.User;
import com.oosd.ecommerce.mapper.CartMapper;
import com.oosd.ecommerce.service.auth.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This defines the implementation of the cart service for managing the cart item entity.
 */
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final UserService userService;

    @Override
    public List<CartItemDto> getAllCartItems() {
        User user = userService.getCurrentUser();
        List<CartItemDto> cartItems = new ArrayList<>();
        for (CartItem cartItem : user.getCartItems()) {
            cartItems.add(CartMapper.map(cartItem));
        }
        return cartItems;
    }

    @Override
    @Transactional
    public void addCartItem(CartItemDto cartItemDto) {
        User user = userService.getCurrentUser();

        CartItem cartItem = CartMapper.map(cartItemDto);

        boolean productInCart = false;
        for (CartItem existingCartItem : user.getCartItems()) {
            if (existingCartItem.getProduct().getId() == cartItem.getProduct().getId()) {
                existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
                productInCart = true;
                break;
            }
        }

        if (!productInCart) {
            user.addCartItem(cartItem);
        }

        userService.save(user);
    }


    @Override
    @Transactional
    public void deleteCartItem(CartItemDto cartItemDto) {
        User user = userService.getCurrentUser();

        CartItem cartItem = CartMapper.map(cartItemDto);

        CartItem cartItemToRemove = findCartItemInUserCart(user, cartItem);

        if (cartItemToRemove != null) {
            user.removeCartItem(cartItemToRemove);
            userService.save(user);
        }
    }

    @Override
    @Transactional
    public void decreaseCartItemQuantity(CartItemDto cartItemDto) {
        User user = userService.getCurrentUser();

        CartItem cartItem = CartMapper.map(cartItemDto);

        CartItem cartItemToUpdate = findCartItemInUserCart(user, cartItem);

        if (cartItemToUpdate != null) {
            int newQuantity = cartItemToUpdate.getQuantity() - cartItem.getQuantity();
            if (newQuantity <= 0) {
                user.removeCartItem(cartItemToUpdate);
            } else {
                cartItemToUpdate.setQuantity(newQuantity);
            }
            userService.save(user);
        }

    }

    @Override
    @Transactional
    public void clearCart() {
        User user = userService.getCurrentUser();

        List<CartItem> cartItems = user.getCartItems();

        cartItems.clear();

        userService.save(user);
    }

    private CartItem findCartItemInUserCart(User user, CartItem cartItem) {
        for (CartItem item : user.getCartItems()) {
            if (item.getProduct().getId() == cartItem.getProduct().getId()) {
                return item;
            }
        }
        return null;
    }
}
