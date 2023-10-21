package com.oosd.ecommerce.controller;

import com.oosd.ecommerce.dto.UserLoginDto;
import com.oosd.ecommerce.dto.UserRegistrationDto;
import com.oosd.ecommerce.service.auth.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

/**
 * This provides the API-endpoints for the authentication.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDTO) {
        return userService.login(userLoginDTO, authenticationManager);
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationDto userRegistrationDTO) {
        return userService.register(userRegistrationDTO);
    }

}
