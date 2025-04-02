package com.coursework.csa_cw.exception;

import com.sun.org.slf4j.internal.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CartNotFoundException extends RuntimeException{

    CartNotFoundException(String message){
        super(message);
    }

}
