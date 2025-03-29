/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.csa_cw.resources;


import com.coursework.csa_cw.dao.AuthorDAO;
import com.coursework.csa_cw.model.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Udith
 */


@Path("/authors")
public class AuthorResource {

    private AuthorDAO authorDAO = new AuthorDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAuthor(Author newAuthor){
        authorDAO.addAuthor(newAuthor);
        return Response.status(Response.Status.CREATED).entity("Author Successfully added").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAuthors(){
        return Response.status(200).entity(authorDAO.getAllAuthors()).build();
    }

    @GET
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorById(@PathParam("id") int authorId){
        return authorDAO.getAuthorById(authorId);
    }

    @PUT
    @Path(("/{id}"))
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAuthor(@PathParam("id") int authorId, Author updatedAuthor){
        Author exisitingAuthor = authorDAO.getAuthorById(authorId);
        if(exisitingAuthor != null){
            updatedAuthor.setId(authorId);
            authorDAO.updateAuthor(updatedAuthor);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteAuthor(@PathParam("id") int authorId){
        authorDAO.deleteAuthor(authorId);
    }
}
