/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.csa_cw.model;

/**
 *
 * @author Udith
 */
public class Book {

    private int id;
    private String title;
    private int authorId;
    private String ISBN;
    private int pubYear;
    private double price;    //In LKR
    private int stockQty;

//    For JSON
    public Book() {
    }

    public Book(int id, String title, int authorId, String ISBN, int pubYear, double price, int stockQty) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.ISBN = ISBN;
        this.pubYear = pubYear;
        this.price = price;
        this.stockQty = stockQty;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthor(int authorId) {
        this.authorId = authorId;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPubYear() {
        return this.pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQty() {
        return this.stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }
}
