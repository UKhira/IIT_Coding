import java.util.Arrays;

public class W2_SelcectionSort_Implemet {
    public static void sort(int[] values) {
        int lastUnsorted = values.length - 1;
        while (lastUnsorted > 0) {
            int maxIndex = 0;
            int maxValue = values[0];

            for (int i = 1; i <= lastUnsorted; i++) {
                if (values[i] > maxValue) {
                    maxIndex = i;
                    maxValue = values[i];
                }
            }
            values[maxIndex] = values[lastUnsorted];
            values[lastUnsorted] = maxValue;
            lastUnsorted--;
        }
        System.out.println(Arrays.toString(values));
    }
    public static void main(String[] args) {
        int[] values = {23, 78 ,23, 90, 98, 29};
        sort(values);
    }
}
