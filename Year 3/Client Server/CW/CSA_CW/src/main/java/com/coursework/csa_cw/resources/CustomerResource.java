/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.csa_cw.resources;

import com.coursework.csa_cw.dao.BookDAO;
import com.coursework.csa_cw.dao.CustomerDAO;

import com.coursework.csa_cw.model.Book;
import com.coursework.csa_cw.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Udith
 */

@Path("/customers")
public class CustomerResource {

    private CustomerDAO customerDAO = new CustomerDAO();

    private BookDAO bookDAO = new BookDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer newCustomer){
        int newCustomerId = newCustomer.getId();
        for(Customer customer:customerDAO.getAllCustomers()){
            if(newCustomerId == customer.getId()){
                return Response.status(Response.Status.CONFLICT).entity("Customer Id already exists").build();
            }
        }
        customerDAO.addCustomer(newCustomer);
        if(newCustomer.getId() == 0){
            return Response.status(Response.Status.CREATED).entity("Customer Successfully added with system generated ID").build();
        }
        else{
            return Response.status(Response.Status.CREATED).entity("Customer Successfully added").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(){
        return Response.status(200).entity(customerDAO.getAllCustomers()).build();
    }

    @GET
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("id") int customerId){
        return customerDAO.getCustomerById(customerId);
    }

    @PUT
    @Path(("/{id}"))
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAuthor(@PathParam("id") int customerId, Customer updatedCustomer){
        Customer exisitingCustomer = customerDAO.getCustomerById(customerId);
        if(exisitingCustomer != null){
            updatedCustomer.setId(customerId);
            customerDAO.updateCustomer(customerId,updatedCustomer);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") int customerId){
        customerDAO.deleteCustomer(customerId);
    }


    @POST
    @Path("/{customerId}/cart/items")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItemsToCart(@PathParam("customerId") int customerId, Book book) {
        boolean isBookValid = bookDAO.getBookById(book.getId()) != null;
        if (isBookValid) {
            boolean isAdded = customerDAO.addItemsToCart(customerId, book);
            if (isAdded) {
                return Response.status(Response.Status.OK).entity("Book successfully added to cart").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Insufficient stock or customer not found").build();
            }
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid book ID").build();
        }
    }

    @GET
    @Path("/{customerId}/cart")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCartItems(@PathParam("customerId") int customerId){
        return Response.status(Response.Status.OK).entity(customerDAO.getCart(customerId)).build();
    }

    @PUT
    @Path("/{customerId}/cart/items/{bookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCartItem(@PathParam("customerId") int customerId, @PathParam("bookId") int bookId, Book updatedBook) {
        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            Book existingBook = bookDAO.getBookById(bookId);
            if (existingBook != null && updatedBook.getStockQty() <= existingBook.getStockQty()) {
                boolean isUpdated = customerDAO.updateCartItem(customerId, bookId, updatedBook);
                if (isUpdated) {
                    return Response.status(Response.Status.OK).entity("Cart item successfully updated").build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Failed to update cart item").build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Invalid book ID or insufficient stock").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
        }
    }

    @DELETE
    @Path("/{customerId}/cart/items/{bookId}")
    public Response deleteCartItem(@PathParam("customerId") int customerId, @PathParam("bookId") int bookId) {
        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            boolean isRemoved = customerDAO.removeCartItem(customerId, bookId);
            if (isRemoved) {
                return Response.status(Response.Status.OK).entity("Cart item successfully removed").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Book not found in cart").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Customer not found").build();
        }
    }

    @POST
    @Path("/{customerId}/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(@PathParam("customerId") int customerId, List<Book> books) {
        boolean isOrderCreated = customerDAO.createOrder(customerId, books);
        if (isOrderCreated) {
            return Response.status(Response.Status.CREATED).entity("Order successfully created").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Failed to create order").build();
        }
    }

    @GET
    @Path("/{customerId}/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersByCustomerId(@PathParam("customerId") int customerId) {
        List<Book> orders = customerDAO.getOrdersByCustomerId(customerId);
        if (!orders.isEmpty()) {
            return Response.status(Response.Status.OK).entity(orders).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("No orders found for customer").build();
        }
    }

    @GET
    @Path("/{customerId}/orders/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("customerId") int customerId, @PathParam("orderId") int orderId) {
        Book order = customerDAO.getOrderById(customerId, orderId);
        if (order != null) {
            return Response.status(Response.Status.OK).entity(order).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Order not found for customer").build();
        }
    }
}


