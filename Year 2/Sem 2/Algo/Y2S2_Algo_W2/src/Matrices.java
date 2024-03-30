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

}
