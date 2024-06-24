package com.example.registration_demo.exception;

public class EntityNotFoundException extends ApplicationException  {

    public EntityNotFoundException(Class<?> clazz, Long id) {
        super(String.format("%s with id: %d not found", clazz.getSimpleName(), id));
    }


}
