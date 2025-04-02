package com.coursework.csa_cw.exception;

import javax.ws.rs.ext.ExceptionMapper;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message){
        super(message);
    }
}
