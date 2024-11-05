package Exercise4;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class Book implements Comparable<Book>{
    private String title;
    private double price;
    private int publishedYear;
    private String authorName;

    DecimalFormat decimalFormat = new DecimalFormat("'LKR'###,##0.00");

    public Book(String title, double price, int year, String author){
        this.title = title;
        this.price = price;
        this.publishedYear = year;
        this.authorName = author;
    }

    // *********** Setter Methods *********** //
    public void setTitle(String title){
        this.title = title;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setYear(int year){
        this.publishedYear = year;
    }

    public void setAuthor(String author){
        this.authorName = author;
    }

    // *********** Getter Methods **************//
    public String getTitle(){
        return this.title;
    }

    public String getPrice(){
        return decimalFormat.format(this.price);
    }

    public int getYear(){
        return this.publishedYear;
    }

    public String getAuthor(){
        return this.authorName;
    }

    public String toString(){
        return (String.format("Book Name: %s %nPrice: %s %nYear of Publish: %d %nAuthor: %s%n",this.title,getPrice(),this.publishedYear, this.authorName));
    }

    public int compareTo(@NotNull Book book) {
        return this.publishedYear - book.publishedYear;
    }
}
