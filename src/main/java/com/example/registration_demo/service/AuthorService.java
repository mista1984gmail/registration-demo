package com.example.registration_demo.service;


import com.example.registration_demo.controller.request.AuthorRequest;
import com.example.registration_demo.service.dto.AuthorDto;

public interface AuthorService {

    String save(AuthorRequest author);

    AuthorDto findById(Long id);

}
