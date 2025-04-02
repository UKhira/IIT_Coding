package com.coursework.csa_cw.exception;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomerNotFoundExceptionMapper extends ExceptionMapper<CustomerNotFoundException> {
}
