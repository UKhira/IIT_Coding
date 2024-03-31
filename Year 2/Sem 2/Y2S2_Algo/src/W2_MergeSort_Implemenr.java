import java.util.Random;

public class W2_MergeSort_Implemenr {
    private static void mergeRange(int[] values, int first, int mid, int last) {
        int size = last + 1 - first;
        int[] temp = new int[size];
        int index1 = first, index2 = mid + 1, tempIndex = 0;

        while (index1 <= mid && index2 <= last) {
            if (values[index1] < values[index2]) {
                temp[tempIndex] = values[index1];
                index1++;
            } else {
                temp[tempIndex] = values[index2];
                index2++;
            }
            tempIndex++;
        }

        while (index1 <= mid) {
            temp[tempIndex] = values[index1];
            index1++;
            tempIndex++;
        }

        while (index2 <= last) {
            temp[tempIndex] = values[index2];
            index2++;
            tempIndex++;
        }
        System.arraycopy(temp, 0, values, first, size);
    }

    private static void sortRange(int[] values, int first, int last) {
        if (last > first) {
            int mid = (first + last) / 2;
            sortRange(values, first, mid);
            sortRange(values, mid + 1, last);
            mergeRange(values, first, mid, last);
        }
    }

    private static void sort(int[] values) {
        sortRange(values, 0, values.length - 1);
    }

    public static int[] randomValues(int howMany) {
        int[] result = new int[howMany];
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            result[i] = random.nextInt() % (10 * howMany);
        }
        return result;
    }

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
            System.out.println("After sorting: ");
            for (int i = 0; i < numValues; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Elapsed Time: " + elapsed + " seconds");
    }
}
