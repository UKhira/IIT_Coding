public class PrintedBook extends Book{
    protected String isbn;

    public PrintedBook(String title, String author, String isbn){
        super(title,author);
        this.isbn = isbn;
    }

    public String toString(){
        return (super.toString() + "ISBN :- " + isbn + "\n");
    }
}
