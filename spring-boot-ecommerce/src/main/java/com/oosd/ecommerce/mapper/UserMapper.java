package com.oosd.ecommerce.mapper;

import com.oosd.ecommerce.dto.UserRegistrationDto;
import com.oosd.ecommerce.entity.CartItem;
import com.oosd.ecommerce.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * This provides a helper function for mapping a user registration dto object to a user object.
 */
public class UserMapper {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static User map(UserRegistrationDto userRegistrationDTO) {
        return User.builder()
                .firstName(userRegistrationDTO.getFirstName())
                .lastName(userRegistrationDTO.getLastName())
                .email(userRegistrationDTO.getEmail())
                .password(passwordEncoder.encode(userRegistrationDTO.getPassword()))
                .cartItems(new ArrayList<CartItem>())
                .build();
    }
}