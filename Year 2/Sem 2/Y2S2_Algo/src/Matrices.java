public class Matrices {
    static int multiplyCount = 0;

    public static void printMatrix(int[][] matrix) {
        int demension = matrix.length;
        for (int i = 0; i < demension; i++) {
            for (int j = 0; j < demension; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        multiplyCount++;
        int dimension = A.length;
        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = 0;
                for (int k = 0; k < dimension; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] slowPower(int[][] matrix, int exponenet) {
        int dimension = matrix.length;
        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        for (int i = 1; i < exponenet; i++) {
            result = multiply(result, matrix);
        }
        return result;
    }

    public static int[][] fastPower(int[][] matrix, int exponent) {
        if (exponent == 1) {
            return matrix;
        }
        if (exponent % 2 == 0) {
            int[][] halfPower = fastPower(matrix, exponent / 2);
            return multiply(halfPower, halfPower);
        } else {
            return multiply(matrix, fastPower(matrix, exponent - 1));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        int exponenet = 1000000;

        System.out.println();
        System.out.println("Using slowPower, with exponent = " + exponenet);
        System.out.println();

        multiplyCount = 0;
        long start = System.currentTimeMillis();
        printMatrix(slowPower(matrix, exponenet));
        long middle = System.currentTimeMillis();

        System.out.println();
        System.out.println("Used " + multiplyCount + " multipicatons, " + (middle - start) + " milideconds");
        System.out.println();

        System.out.println();
        System.out.println("Using fastpower, with exponenet: " + exponenet);
        System.out.println();

        multiplyCount = 0;
        printMatrix(fastPower(matrix, exponenet));
        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("Used " + multiplyCount + " mutiplicationd. " + (end - middle) + " miliseconds");
        System.out.println();
    }

}
