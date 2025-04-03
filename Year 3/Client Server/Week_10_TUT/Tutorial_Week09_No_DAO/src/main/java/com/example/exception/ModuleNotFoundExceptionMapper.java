package com.example.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class ModuleNotFoundExceptionMapper implements ExceptionMapper<ModuleNotFoundException> {

    private static final Logger logger = Logger.getLogger(ModuleNotFoundException.class.getName());

    @Override
    public Response toResponse(ModuleNotFoundException exception) {
        logger.warning("Student not Found:" + exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
    }
}
