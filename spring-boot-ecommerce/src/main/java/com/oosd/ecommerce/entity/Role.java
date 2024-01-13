package com.oosd.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * This defines the structure of a role.
 * This class is necessary to work with Spring Security.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "name")
    private String name;
}