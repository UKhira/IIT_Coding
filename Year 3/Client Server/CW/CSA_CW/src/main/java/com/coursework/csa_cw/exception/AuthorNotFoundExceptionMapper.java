package com.coursework.csa_cw.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class AuthorNotFoundExceptionMapper implements ExceptionMapper<AuthorNotFoundException> {

    private static final Logger logger = Logger.getLogger(AuthorNotFoundExceptionMapper.class.getName());

    @Override
    public Response toResponse(AuthorNotFoundException exception) {
        logger.warning("Author Not Found" + exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity(exception.getMessage()).build();
    }
}
