public class Book {

    private String title;
    private Author author;
    private String ISBN;
    private String pubYear;
    private double price;
    private int stockQty;

//    For JSON
    public Book() {
    }

    public Book(String title, Author author, String ISBN, String pubYear, double price, int stockQty) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.pubYear = pubYear;
        this.price = price;
        this.stockQty = stockQty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPubYear() {
        return pubYear;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }
}
