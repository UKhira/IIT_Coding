import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // 2. Create instances of UserValidator and UserDataStore
        UserValidator validator = new UserValidator();
        UserDataStore dataStore = new UserDataStore();

        // 3. Create a List to store Thread objects
        List<Thread> threads = new ArrayList<>();

        // 4. Create a lock object for synchronisation
        Object lock = new Object();

        // 5. Initialise a boolean variable to control the input loop
        boolean continueInput = true;

//        2. User Input Loop (while addMoreUsers)
        while(continueInput){

//       7. Simulate concurrent user input (3 users at a time using for loop)
            for(int i = 0; i < 3; i++) {

//                 8. Prompt the user to enter a name
                System.out.println("Enter name: ");

//                9. Read the name from the input
                String name = scanner.next();

//                10. Prompt the user to enter an age
                System.out.println("Enter age: ");

//                11. Read the age from the input
                int age = scanner.nextInt();

//                12. Create a UserProcessor object
                UserProcessor userProcessor = new UserProcessor(validator, dataStore, lock, name, age);

//                13. Create a Thread object with the UserProcessor object
                Thread thread = new Thread(userProcessor);

//                14. Add the thread to the thread list
                threads.add(thread);

//                15. Consume the newline character left by nextInt()
                scanner.nextLine();
            }
//

//                 16. Ask the user if they want to add more users
                System.out.println("Do you want to add more users (y/n): ");
//                17. Read the user's response using nextLine()
                String response = scanner.nextLine();

//                18. Update the loop control variable based on the response
                if(response.equalsIgnoreCase("No"))
                    continueInput = false;
        }
//        19. Iterate through the thread list and start/join each thread
//        3. Thread Execution (for Thread t : threadList)
//        20. Start the thread
        for(Thread thread: threads){
            thread.start();
        }
//        21. Wait for the thread to finish (join)
        for(Thread thread: threads){
            try{
                thread.join();
            }

//            21.1 Handle potential InterruptedException
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//          4. Displaying Users
//          22. Display all users stored in the data store
        System.out.println("All users");
        for(User user : dataStore.getAllUsers()){
            System.out.println(user);
        }
    }
}
