import static java.util.Arrays.sort;
import java.util.Random;

public class FindMultiples {
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

    public static int findDuplicateSorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static int findTriplicateSorted(int[] numbers) {
        for (int i = 2; i < numbers.length; i++) {
            if ((numbers[i] == numbers[i - 1]) && (numbers[i] == numbers[i - 2])) {
                return i;
            }
        }
        return -1;
    }

    public static int[] randomValues(int howMany, boolean wideRange) {
        int[] result = new int[howMany];
        int range = howMany;
        if (wideRange) {
            int root = howMany / 2;
            for (int i = 0; i < 10; i++) {
                root = (root + howMany / root) / 2;
            }
            range *= root;
        }
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            result[i] = random.nextInt() % range;
        }
        return result;
    }

    public static void main(String[] args) {
        int numValue = 100;
        boolean triplicates = false;
        boolean sortData = false;
        boolean printData = true;

        int[] data = randomValues(numValue, !triplicates);
        if (sortData) {
            sort(data);
        }

        if (printData) {
            System.out.println("Input Values: ");
            for (int i = 0; i < data.length; i++) {
                System.out.println(data[i] + " ");
            }
            System.out.println();
        }
        int result = 0;
        long start = System.currentTimeMillis();
        if (triplicates) {
            if (sortData) {
                result = findTriplicateSorted(data);
            } else {
                result = findTriplicate(data);
            }
        }
        else{
            if(sortData){
                result = findDuplicateSorted(data);
            }
            else{
                result = findDuplicate(data);
            }
        }
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(result > 0){
            System.out.println("Result: " + result + " (value: + " + data[result] + ")");
        }
        else{
            System.out.println("Result: nothing found");
        }
        System.out.println("Elapsed Time = " + elapsed + " seconds");
    }
}