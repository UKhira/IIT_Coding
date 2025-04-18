package ExceptionHandle.MultipleCatch;

public class Example2 {
    public static void main(String[] args) {
// Here, numer is longer than denom
        int[] numer = {4, 8, 16, 32, 64, 128, 256, 512};
        int[] denom = {2, 0, 4, 4, 0, 8};
        for (int i = 0; i < numer.length; i++){
            try{
                System.out.println(numer[i] + " / " + denom[i] + " is " + numer[i]/ denom[i]);
            }
            catch (ArrayIndexOutOfBoundsException exc){
// Catch the exception
                System.out.println ("No matching element found.");
            }
            catch (Throwable exc){
// Catch the exception
                System.out.println ("Some Exception Occurred");
            }
        }
    }
}
