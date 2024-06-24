package com.example.registration_demo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {

    private String username;
    private String address;
    private String email;
    private String telephone;
    private LocalDateTime registrationDate;

}
