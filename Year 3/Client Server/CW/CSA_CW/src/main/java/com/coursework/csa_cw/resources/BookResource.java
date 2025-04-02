/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.csa_cw.resources;

import com.coursework.csa_cw.dao.BookDAO;
import com.coursework.csa_cw.model.Author;
import com.coursework.csa_cw.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Udith
 */

@Path("/books")
public class BookResource {

    private BookDAO bookDAO = new BookDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(Book newBook) {
        boolean validBookAdd = bookDAO.addBook(newBook);
        if (validBookAdd) {
            return Response.status(Response.Status.CREATED).entity("Book successfully added").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid author ID").build();

        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks(){
        return Response.status(200).entity(bookDAO.getAllBooks()).build();
    }

    @GET
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBookById(@PathParam("id") int bookId){
        return bookDAO.getBookById(bookId);
    }

    @PUT
    @Path(("/{id}"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") int bookId, Book updatedBook){
        boolean isUpdated = bookDAO.updateBookById(bookId, updatedBook);
        if (isUpdated) {
            return Response.status(Response.Status.OK).entity("Book successfully updated").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid author ID or book not found").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") int bookId){
        bookDAO.deleteBook(bookId);
    }
}
