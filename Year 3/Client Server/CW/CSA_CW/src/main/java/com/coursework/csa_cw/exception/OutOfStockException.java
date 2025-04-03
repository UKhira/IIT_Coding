package com.coursework.csa_cw.exception;

public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String message){
        super(message);
    }
}
