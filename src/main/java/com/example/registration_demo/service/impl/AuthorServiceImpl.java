package com.example.registration_demo.service.impl;

import com.example.registration_demo.controller.request.AuthorRequest;
import com.example.registration_demo.entity.Author;
import com.example.registration_demo.exception.EntityNotFoundException;
import com.example.registration_demo.repository.AuthorRepository;
import com.example.registration_demo.service.AuthorService;
import com.example.registration_demo.service.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public String save(AuthorRequest author) {
        Author authorForSave = new Author();
        authorForSave.setUsername(author.getUsername());
        authorForSave.setAddress(author.getAddress());
        authorForSave.setTelephone(author.getTelephone());
        authorForSave.setEmail(author.getEmail());
        authorForSave.setRegistrationDate(LocalDateTime.now());
        authorForSave.setBlocked(false);
        Author authorSaved = authorRepository.save(authorForSave);
        if (authorSaved.getId() != null) {
            return "Author with id: " + authorSaved.getId()+ " saved!!!";
        } else {
            return "Author did not save!!!";
        }
    }

    @Override
    public AuthorDto findById(Long id) {
        Author authorFromDb = getById(id);
        AuthorDto authorDto = new AuthorDto();
        authorDto.setUsername(authorFromDb.getUsername());
        authorDto.setAddress(authorFromDb.getAddress());
        authorDto.setEmail(authorFromDb.getEmail());
        authorDto.setTelephone(authorFromDb.getTelephone());
        authorDto.setRegistrationDate(authorFromDb.getRegistrationDate());
        return authorDto;
    }

    private Author getById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Author.class, id));
    }
}
