package com.example.exception;

public class ModuleNotFoundException extends RuntimeException{

    public ModuleNotFoundException(String message){
        super(message);
    }
}
