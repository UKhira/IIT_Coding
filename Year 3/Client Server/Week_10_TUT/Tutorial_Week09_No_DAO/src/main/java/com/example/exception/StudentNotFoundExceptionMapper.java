package com.example.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class StudentNotFoundExceptionMapper implements ExceptionMapper<StudentNotFoundException> {

    private static final Logger logger = Logger.getLogger(StudentNotFoundExceptionMapper.class.getName());

    @Override
    public Response toResponse(StudentNotFoundException e) {
        logger.warning("Student not Found:" + e.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).type(MediaType.TEXT_PLAIN).build();
    }
}
