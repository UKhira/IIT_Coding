package com.coursework.csa_cw.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class CartNotFoundExceptionMapper implements ExceptionMapper<CartNotFoundException> {

    private static final Logger logger = Logger.getLogger(CartNotFoundExceptionMapper.class.getName());

    @Override
    public Response toResponse(CartNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
    }
}
