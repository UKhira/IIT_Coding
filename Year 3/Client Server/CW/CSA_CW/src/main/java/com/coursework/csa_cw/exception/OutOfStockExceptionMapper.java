package com.coursework.csa_cw.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class OutOfStockExceptionMapper implements ExceptionMapper<OutOfStockException> {

    private static final Logger logger = Logger.getLogger(OutOfStockExceptionMapper.class.getName());

    @Override
    public Response toResponse(OutOfStockException exception) {
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
    }
}
