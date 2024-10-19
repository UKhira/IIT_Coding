public class Book {
    protected String title;
    protected String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void setBookTitle(String title){
        this.title = title;
    }

    public void setBookAuthor(String author){
        this.author = author;
    }

    public String toString(){
        String bookInfo = String.format("Title :- %s%nAuthor:- %s%n", title,author);
        return bookInfo;
    }
}
