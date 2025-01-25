package Sample.Exceptions;

import java.util.Scanner;

public class ExceptionExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Enter a Number: ");
            int num1 = scanner.nextInt();
            System.out.println("Enter another Number: ");
            int num2 = scanner.nextInt();

            int result = num1/num2;
            System.out.println("Result of Division: " + result);
        }
        catch (ArithmeticException e){
            System.out.println("Error: Division by Zero is not allowed");
        }
        catch(Exception e){
            System.out.println("An unexpected error occurred");
        }

        try{
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Enter an index to get the corresponding number from the array");
            int index = scanner.nextInt();

            int value = numbers[index];
            System.out.println("Value at Index " + index + ": " + value);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Index out of bound. Please enter a valid indexx");
        }
        catch(Exception e){
            System.out.println("An unexpected Error occurred");
            e.printStackTrace();
        }

        // Task
        try{
            System.out.println("Enter Some text to get its length: ");
            String text = scanner.next();

            System.out.println("The length of text is: " + text.length());
        }
        catch (NullPointerException e){
            System.out.println("Error: Null Exception. Please enter something");
        }
        catch (Exception e){
            System.out.println("An unexpected error occurred");
        }

        finally {
            scanner.close();
        }
    }
}
