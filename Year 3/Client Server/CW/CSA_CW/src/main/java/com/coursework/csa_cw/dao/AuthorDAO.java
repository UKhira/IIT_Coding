package com.coursework.csa_cw.dao;

import com.coursework.csa_cw.model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AuthorDAO {

//    ArrayList to store all Author Objects which will created or modified</b>
    private static List<Author> authorList = new ArrayList<>();

//    Logger to keep system logs in terminal</b>

    private static final Logger logger = Logger.getLogger(AuthorDAO.class.getName());

//     Static block to initialize AuthorList with sample records

    static{
        authorList.add(new Author(1, "Conan Doyle", "Memories and Adventure"));
        authorList.add(new Author(2, "Enid Blyton", "Enid Blyton: The Biography"));
    }

    /**
     * This Method will add Author objects to the List, If author Id is not supplied by a user, it will call getNextAuthorId() method and generate an Id. If the user has sent the Id, it will be set
     * @param newAuthor
     */
    public void addAuthor(Author newAuthor){
        if(newAuthor.getId() == 0) {    // This condition will pick user not sending authorIds
            newAuthor.setId(getNextAuthorId());
        }
        authorList.add(newAuthor);
        logger.info("Author successfully added");
    }

    /**
     * This method will return the List of Authors
     * @return AuthorList
     */
    public List<Author> getAllAuthors(){
        return authorList;
    }

    /**
     * This method will search a relevant author record for a given ID, if ID is not found return a null;
     * @param authorId
     * @return specific Author object by given ID
     */
    public Author getAuthorById(int authorId){
        for(Author author: authorList){
            if(author.getId() == authorId){
                logger.info("Author details successfully retrieved");
                return author;
            }
        }
        logger.warning("Author not found");
        return null;
    }

    /**
     * This method will update an existing object in AuthorList by given ID, If no ID found it will output a warning level log
     * @param id
     * @param authorToBeUpdated
     */
    public void updateAuthor(int id, Author authorToBeUpdated){
        for(int i = 0; i < authorList.size(); i++){
            Author currentAuthor = authorList.get(i);
            if(currentAuthor.getId() == id){
                authorList.set(i, authorToBeUpdated);
                logger.info("Author successfully updated");
            }
        }
        logger.warning("No Matching record");
    }

    /**
     * This method will remove an Author from list for a given ID, If exists
     * @param authorid
     */
    public void deleteAuthor(int authorid){
        authorList.removeIf(author ->  author.getId() == authorid);
    }

    /**
     * This method will return next index which can get as author ID from authorList
     * @return
     */
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
