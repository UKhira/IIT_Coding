package com.example.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.logging.Logger;

public class TeacherNptFoundExceptionMapper implements ExceptionMapper<TeacherNotFoundException> {

    private static final Logger logger = Logger.getLogger(TeacherNotFoundException.class.getName());
    @Override
    public Response toResponse(TeacherNotFoundException e) {
        logger.warning(e.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).type(MediaType.TEXT_PLAIN).build();
    }
}
