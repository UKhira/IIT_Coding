/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.csa_cw.resources;

import com.coursework.csa_cw.model.Author;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Udith
 */

@Path("/authors")
public class AuthorResource {
    private static final Logger logger = Logger.getLogger(AuthorResource.class.getName());
    private static final List<Author> authors = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAllAuthors(){
        if(authors.isEmpty()){
            logger.info("No Available books currently im store.");
        };
        return authors;
    }
}
