package Exercise4;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MenuConsole {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList <Book> bookList = new ArrayList<Book>();

    public static void main(String[] args) {
        enterBookInfo();
    }

    public static void enterBookInfo(){
        String keyPress = "c";
        while (keyPress.equalsIgnoreCase("C"))
        {
            System.out.println("Enter Book Title: ");
            String title = scanner.next();
            scanner.nextLine();

            System.out.println("Enter Price: ");
            double price = scanner.nextDouble();

            System.out.println("Enter Year of Published");
            int year = scanner.nextInt();

            System.out.println("Enter Author name");
            String author = scanner.next();
            scanner.nextLine();

            Book book = new Book(title,price,year,author);
            bookList.add(book);

            System.out.println("Press C to continue ");
            keyPress = scanner.next();
        }

        System.out.println(bookList);

//        Sorted List by Year
        Collections.sort(bookList);
        System.out.println(bookList);

        placeBooksOnShelves(bookList);
    }

    public static void placeBooksOnShelves(@NotNull ArrayList <Book> bookList){
        HashMap<Book, Integer> hashMap = new HashMap<Book, Integer>();

        for(int i = 0; i < bookList.size(); i++){
            System.out.println("Please enter the shelf number where book " + bookList.get(i).getTitle() + " should be placed on");
            int shelf = scanner.nextInt();

            hashMap.put(bookList.get(i), shelf);
        }
        viewShelf(hashMap);
    }

    public static void viewShelf(@NotNull HashMap<Book,Integer> shelfList){
        System.out.println("Enter the shelf you want to view ");
        int shelfNo = scanner.nextInt();

        System.out.println("Shelf Number " + shelfNo + " contains ");
        Set set = shelfList.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();

            if(shelfNo == (int)entry.getValue()){
                System.out.println(((Book)entry.getKey()).getTitle());
            }
        }
    }
}