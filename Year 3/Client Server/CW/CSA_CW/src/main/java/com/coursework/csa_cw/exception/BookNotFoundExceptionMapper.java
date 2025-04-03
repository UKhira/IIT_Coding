package com.coursework.csa_cw.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class BookNotFoundExceptionMapper implements ExceptionMapper<BookNotFoundException> {

    private static final Logger logger = Logger.getLogger(BookNotFoundExceptionMapper.class.getName());

    @Override
    public Response toResponse(BookNotFoundException exception) {
        logger.warning("Book not found " + exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
    }
}
