package com.oosd.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This defines the structure of a user login data transfer object.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDto {
    private String email;
    private String password;

}
