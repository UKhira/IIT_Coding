
import java.util.Arrays;
import java.util.Random;

public class FindMultipliers {
    /*
     * Find an index where a value in the array occurs for the second time
     * Returns -1 if no such index exists
     */

    public static int findDuplicate(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int findTriplicate(int[] numbers) {
        /*
         * for (int i = 0; i < numbers.length; i++){
         * for (int j = 0; j < i; j++){
         * for (int k = 0; k < j; k++){
         * if (numbers[i] == numbers[j] && numbers[j] == numbers[k]){
         * return i;
         * }
         * }
         * }
         * }
         * return -1;
         */
        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
                if (count == 2) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(findDuplicate(numbers));
        System.out.println(findTriplicate(numbers));
    }
}