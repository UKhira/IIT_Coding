import java.util.Random;

public class W3_BubbleSort {
    public static void main(String[] args) {
        int numValues = 30;
        boolean printResults = true;

        int[] a = randomValues(numValues);
        if (printResults) {
            System.out.println("Before sorting: ");
            for (int i = 0; i < numValues; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        long start = System.currentTimeMillis();
        sort(a);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if (printResults) {
            System.out.println("After sorting ");
            for (int i = 0; i < numValues; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Elapsed Time = " + elapsed + " seconds");
    }

    public static int[] randomValues(int howMany) {
        int[] result = new int[howMany];
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            result[i] = random.nextInt() % (10 * howMany);
        }
        return result;
    }

    public static void sort(int[] values) {
        int lastUnsorted = values.length - 1;
        while (lastUnsorted > 0) {
            for (int i = 0; i < lastUnsorted; i++) {
                if (values[i] > values[i + 1]) {
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                }
            }
            lastUnsorted--;
        }
    }
}
