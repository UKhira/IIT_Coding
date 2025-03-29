package com.coursework.csa_cw.dao;

import com.coursework.csa_cw.model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AuthorDAO {

//  ArrayList to add Author object created within everywhere (static)
    private static List<Author> authorList = new ArrayList<>();

//    Logger
    private static final Logger logger = Logger.getLogger(AuthorDAO.class.getName());

//    initialize list with some objects
    static{
        authorList.add(new Author(1, "Conan Doyle", "Memories and Adventure"));
        authorList.add(new Author(2, "Enid Blyton", "Enid Blyton: The Biography"));
    }

//    Add new author/s
    public void addAuthor(Author newAuthor){
        int authorId = getNextAuthorId();
        newAuthor.setId(authorId);
        authorList.add(newAuthor);
        logger.info("Author successfully added");
    }

//    Get all Authors
    public List<Author> getAllAuthors(){
        return authorList;
    }

//      Get an Author by Id
    public Author getAuthorById(int authorId){
        for(Author author: authorList){
            if(author.getId() == authorId){
                return author;
            }
        }
        return null;
    }

//    Update an existing author
    public void updateAuthor(Author authorToBeUpdated){
        System.out.println("Method called");
        for(int i = 0; i < authorList.size(); i++){
            Author currentAuthor = authorList.get(i);
            if(currentAuthor.getId() == authorToBeUpdated.getId()){
                authorList.set(i, authorToBeUpdated);
                logger.info("Author successfully updated");
            }
        }
        logger.warning("No Matching record");
    }

//    Remove an author
    public void deleteAuthor(int authorid){
        authorList.removeIf(author ->  author.getId() == authorid);
    }

    public int getNextAuthorId() {
        int idTracker = 0;
        for (Author author : authorList) {
            int authorId = author.getId();
            if (authorId > idTracker) {
                idTracker = authorId;
            }
        }
        return idTracker + 1;
    }
}
