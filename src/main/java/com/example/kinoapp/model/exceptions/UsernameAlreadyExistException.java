package com.example.kinoapp.model.exceptions;

public class UsernameAlreadyExistException extends RuntimeException{
    public UsernameAlreadyExistException(String username){
        super(String.format("User with username: %s already exists",username));
    }
}
