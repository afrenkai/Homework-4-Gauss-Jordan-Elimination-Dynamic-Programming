import java.util.Arrays;

public class GaussJordan {
    public static float[] elim(float[][] A, float[] b) {
        int n = b.length;
        float[][] augmentedMatrix = new float[n][n + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n] = b[i];
        }

        for (int i = 0; i < n; i++) {
            float pivot = augmentedMatrix[i][i];
            if (pivot == 0) {
                //handle shortcoming of first algo
                for (int j = i + 1; j < n; j++) {
                    if (augmentedMatrix[j][i] != 0) {
                        float[] temp = augmentedMatrix[i];
                        augmentedMatrix[i] = augmentedMatrix[j];
                        augmentedMatrix[j] = temp;
                        pivot = augmentedMatrix[i][i];
                        break;
                    }
                }
                if (pivot == 0) {
                    throw new ArithmeticException("Matrix is singular or nearly singular.");
                }
            }
            // Norm pivot 
            for (int j = 0; j <= n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    float factor = augmentedMatrix[j][i];
                    for (int k = 0; k <= n; k++) {
                        augmentedMatrix[j][k] -= factor * augmentedMatrix[i][k];
                    }
                }
            }
        }
        float[] solution = new float[n];
        for (int i = 0; i < n; i++) {
            solution[i] = augmentedMatrix[i][n];
        }

        return solution;
    }

    public static void main(String args[]) {
        float[][] A = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1},
            {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            {11, -10, 9, -8, 7, -6, 5, -4, 3, -2, 1}
        };

        float[] b = {2047, 3, 12, 48, 384, 1536, 5, 50, 1952, 4083, 459};

        float[] solution = elim(A, b);
        System.out.println("Solution: " + Arrays.toString(solution));
    }
}
