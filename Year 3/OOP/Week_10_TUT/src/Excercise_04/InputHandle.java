package Excercise_04;

import java.util.Scanner;

public class InputHandle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int value = 0;
        System.out.println("Please enter an integer");

        if(input.hasNextInt()){
            value = input.nextInt();
            System.out.println("Value: " + value);
        }
        else{
            System.out.println("Please enter an integer value");
        }
    }
}
