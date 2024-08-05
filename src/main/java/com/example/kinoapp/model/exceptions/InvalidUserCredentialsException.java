package com.example.kinoapp.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{

    public InvalidUserCredentialsException(){
        super("Invalid User Credentials Exception");
    }
}
