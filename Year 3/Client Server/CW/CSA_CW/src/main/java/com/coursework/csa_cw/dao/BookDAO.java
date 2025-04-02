package com.coursework.csa_cw.dao;

import com.coursework.csa_cw.model.Author;
import com.coursework.csa_cw.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

//    ArrayList to Store all Book objects which created or modified within Project
    private static List<Book> bookList = new ArrayList<>();

//    Reference to AuthorDAO class
    private static AuthorDAO authorDAO = new AuthorDAO();

//    Static block to initialize BooList
    static {
        bookList.add(new Book(1, "Famous Five" , authorDAO.getAuthorById(2).getId(), "3-345-32454-9", 2000, 2500.00, 17));
        bookList.add(new Book(2, "A Study in Scarlet", authorDAO.getAuthorById(1).getId(), "1-234-56789-0", 1887, 3400.00, 12));
        bookList.add(new Book(3, "Secret Seven", authorDAO.getAuthorById(2).getId(), "2-652-89256-9", 1982, 2500.00, 10));
    }


    /**
     * Get a book/s which written by specific author
     * @param authorId
     * @return Books related to given Id
     */
    public List<Book> getBooksByAuthorId(int authorId) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthorId() == authorId) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    /**
     * Add books to bookList
     * @param newBook
     * @return a boolean whether process is success or not
     */
    public boolean addBook(Book newBook) {
        Author author = authorDAO.getAuthorById(newBook.getAuthorId());
        if (author != null) {
            if(newBook.getId() == 0){
                newBook.setId(getNextBookId());
            }
            bookList.add(newBook);
            return true;
        }
        return false;
    }

    /**
     * Get all books in bookList
     * @return booList arrayList
     */
    public List<Book> getAllBooks(){
        return bookList;
    }

    /**
     * Retrive a specific book by its Id
     * @param bookId
     * @return the book
     */
    public Book getBookById(int bookId){
        for(Book book: bookList){
            if(book.getId() == bookId){
                return book;
            }
        }
        return null;
    }

    /**
     * Update attributes of book by Its Id
     * @param id
     * @param updatedBook
     * @return a boolean, whether process is success or not
     */
    public boolean updateBookById(int id,Book updatedBook) {

        for(int i = 0; i < bookList.size(); i++){
            Book currentBook = bookList.get(i);
            if(currentBook.getId() == id){
                boolean authorCheck = isValidAuthorId(updatedBook.getAuthorId());
                if(authorCheck){
                    bookList.set(i, updatedBook);
                    return true;
                }
                System.out.println("Level 2 check");
            }
            System.out.println("Level 3 check");
        }
        System.out.println("Final check");
        return false;
    }

    /**
     * Check if the given Author exists in AuthorList in AuthorDAO
     * @param authorId
     * @return a boolean depending on whether author exists or not
     */
    public boolean isValidAuthorId(int authorId){
        for(Author author: authorDAO.getAllAuthors()){
            if(author.getId() == authorId){
                return true;
            }
        }
        return false;
    }

    /**
     * Generate an ID to add new book
     * @return next available index for bookID
     */
    public int getNextBookId() {
        int idTracker = 0;
        for (Book book : bookList) {
            int bookId = book.getId();
            if (bookId > idTracker) {
                idTracker = bookId;
            }
        }
        return idTracker + 1;
    }
}
