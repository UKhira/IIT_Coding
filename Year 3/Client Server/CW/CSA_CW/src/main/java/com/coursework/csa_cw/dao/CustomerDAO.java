package com.coursework.csa_cw.dao;

import com.coursework.csa_cw.model.Book;
import com.coursework.csa_cw.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerDAO {

    private static List <Customer> customerList = new ArrayList<>();

    private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

    static{
        customerList.add(new Customer(1, "Sarath", "Edirimuni", "sararthE@gmail.com", "saw223233"));
        customerList.add(new Customer(2, "Danuka", "Hewage", "danukah@yahoo.com", "2334343213"));
    }

    public void addCustomer(Customer newCustomer){
        if(newCustomer.getId() == 0) {    // This condition will pick user not sending authorIds
            newCustomer.setId(getNextCustomerId());
        }
        customerList.add(newCustomer);
        logger.info("Customer successfully added");
    }

    public List<Customer> getAllCustomers(){
        return customerList;
    }

    public Customer getCustomerById(int customerid){
        for(Customer customer: customerList){
            if(customer.getId() == customerid){
                logger.info("Customer details successfully retrieved");
                return customer;
            }
        }
        logger.warning("Customer not found");
        return null;
    }

    public void updateCustomer(int id, Customer customerToBeUpdated){
        for(int i = 0; i < customerList.size(); i++){
            Customer currentCustomer = customerList.get(i);
            if(currentCustomer.getId() == id){
                customerList.set(i, customerToBeUpdated);
                logger.info("Customer successfully updated");
            }
        }
        logger.warning("No Matching record");
    }

    public void deleteCustomer(int customerId){
        customerList.removeIf(customer ->  customer.getId() == customerId);
    }

    public boolean addItemsToCart(int customerId, Book book) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            BookDAO bookDAO = new BookDAO();
            Book existingBook = bookDAO.getBookById(book.getId());
            if (existingBook != null && book.getStockQty() <= existingBook.getStockQty()) {
                customer.getCart().add(book);
                logger.info("Book successfully added to cart");
                return true;
            } else {
                logger.warning("Insufficient stock or book not found");
                return false;
            }
        }
        logger.warning("Customer not found");
        return false;
    }

    public List<Book> getCart(int customerId){
        return getCustomerById(customerId).getCart();
    }

    public boolean updateCartItem(int customerId, int bookId, Book updatedBook) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            BookDAO bookDAO = new BookDAO();
            Book existingBook = bookDAO.getBookById(bookId);
            if (existingBook != null) {
                for (Book book : customer.getCart()) {
                    if (book.getId() == bookId) {
                        if (updatedBook.getStockQty() > existingBook.getStockQty()) {
                            logger.warning("Insufficient stock for the requested quantity");
                            return false;
                        }
                        book.setStockQty(updatedBook.getStockQty());
                        logger.info("Cart item successfully updated");
                        return true;
                    }
                }
                logger.warning("Book not found in cart");
                return false;
            } else {
                logger.warning("Book not found");
                return false;
            }
        }
        logger.warning("Customer not found");
        return false;
    }

    public boolean removeCartItem(int customerId, int bookId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            for (Book book : customer.getCart()) {
                if (book.getId() == bookId) {
                    customer.getCart().remove(book);
                    logger.info("Cart item successfully removed");
                    return true;
                }
            }
            logger.warning("Book not found in cart");
            return false;
        }
        logger.warning("Customer not found");
        return false;
    }

    public boolean createOrder(int customerId, List<Book> books) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            BookDAO bookDAO = new BookDAO();
            for (Book book : books) {
                Book existingBook = bookDAO.getBookById(book.getId());
                if (existingBook == null || book.getStockQty() > existingBook.getStockQty()) {
                    logger.warning("Invalid book ID or insufficient stock for book ID: " + book.getId());
                    return false;
                }
            }
            for (Book book : books) {
                Book existingBook = bookDAO.getBookById(book.getId());
                existingBook.setStockQty(existingBook.getStockQty() - book.getStockQty());
            }
            customer.getCart().clear();
            customer.getCart().addAll(books);
            logger.info("Order successfully created for customer ID: " + customerId);
            return true;
        }
        logger.warning("Customer not found");
        return false;
    }

    public List<Book> getOrdersByCustomerId(int customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            return customer.getCart();
        }
        logger.warning("Customer not found");
        return new ArrayList<>();
    }

    public Book getOrderById(int customerId, int orderId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            for (Book book : customer.getCart()) {
                if (book.getId() == orderId) {
                    logger.info("Order details successfully retrieved for order ID: " + orderId);
                    return book;
                }
            }
            logger.warning("Order not found for order ID: " + orderId);
        } else {
            logger.warning("Customer not found for customer ID: " + customerId);
        }
        return null;
    }

    public int getNextCustomerId() {
        int idTracker = 0;
        for (Customer customer : customerList) {
            int customerId = customer.getId();
            if (customerId > idTracker) {
                idTracker = customerId;
            }
        }
        return idTracker + 1;
    }
}
