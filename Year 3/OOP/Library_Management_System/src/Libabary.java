public class Libabary {
    public static void main(String[] args) {
        Book book = new Book("Tarzan", "Edgar R. Buroghs");
        System.out.println(book);

        EBook ebook = new EBook("Sherlock Holmes", "Arthur Conon Doyle", "https://www.javatpoint.com/super-keyword");
        System.out.println(ebook);

        PrintedBook printedBook = new PrintedBook("Famous Five", "Enid Blyton","ISBN-13: 978-1-56619-909-4");
        System.out.println(printedBook);
    }
}
