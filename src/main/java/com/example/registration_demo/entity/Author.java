package com.example.registration_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id", updatable = false)
    private Long id;

    @Column(name="username",
            nullable = false, unique = true)
    private String username;

    @Column(name="address",
            nullable = false)
    private String address;

    @Column(name="email",
            nullable = false, unique = true)
    private String email;

    @Column(name="telephone",
            nullable = false, unique = true)
    private String telephone;

    @Column(name="registration_date",
            nullable = false)
    private LocalDateTime registrationDate;

    @Column(name="is_blocked",
            nullable = false)
    private boolean isBlocked;

}
