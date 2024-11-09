package Excercise_01;

public class Exception {
    public static void main(String[] args) {
        int[] myArray = new int[5];
        try{
            System.out.println(myArray[5]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("The element " + e.getMessage() + " does not exists" );
        }

    }
}
