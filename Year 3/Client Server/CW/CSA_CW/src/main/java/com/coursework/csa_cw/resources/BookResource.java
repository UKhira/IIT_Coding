/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.csa_cw.resources;

import com.coursework.csa_cw.model.Author;
import com.coursework.csa_cw.model.Book;

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

@Path("/books")
public class BookResource {

    private static final Logger logger = Logger.getLogger(BookResource.class.getName());
    private static final List <Book> books = new ArrayList<>();

    static{
        addInitialBooks();
    }

//    When opening application these books will be automatically added
    public static void addInitialBooks(){
        books.add(new Book("A Study in Scarlet",new Author(1, "Conan Doyle", "Memories and Adventure"), "0-439-02348-3", 1887, 3400.00, 12));
        books.add(new Book("Famous Five", new Author(2, "Enid Blyton", "Enid Blyton: The Biography"),"1-343-123043-3", 1233, 1500.00, 10));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks(){
        if(books.isEmpty()){
            logger.info("No Available books currently im store.");
        };
        return books;
    }

}
