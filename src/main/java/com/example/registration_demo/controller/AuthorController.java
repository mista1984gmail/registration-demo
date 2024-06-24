package com.example.registration_demo.controller;

import com.example.registration_demo.controller.request.AuthorRequest;
import com.example.registration_demo.controller.response.AuthorResponse;
import com.example.registration_demo.service.AuthorService;
import com.example.registration_demo.service.dto.AuthorDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String save(@RequestBody AuthorRequest authorRequest) {
        return authorService.save(authorRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse findById(@PathVariable Long id) {
        AuthorDto authorDto = authorService.findById(id);
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setUsername(authorDto.getUsername());
        authorResponse.setAddress(authorDto.getAddress());
        authorResponse.setEmail(authorDto.getEmail());
        authorResponse.setTelephone(authorDto.getTelephone());
        authorResponse.setRegistrationDate(authorDto.getRegistrationDate());
        return authorResponse;
    }

}
