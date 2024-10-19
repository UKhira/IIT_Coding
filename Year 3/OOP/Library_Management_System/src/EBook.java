public class EBook extends Book{
    protected String url;

    public EBook(String title, String author, String url){
        super(title,author);
        this.url = url;
    }

    public String toString(){
        return (super.toString() + "URL :- " + url + "\n");
    }


}
