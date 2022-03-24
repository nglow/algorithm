package problem.Inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixMaxSum {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(scanner.next());
            }
        }

        var matrixMaxSum = new MatrixMaxSum();
        int maxSum = matrixMaxSum.solution(n, matrix);

        System.out.println(maxSum);
    }

    private int solution(int n, int[][] matrix) {
        int[] sumList= new int[2 * n + 2];

        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            int horizontalSum = 0;
            int verticalSum = 0;
            for (int j = 0; j < n; j++) {
                horizontalSum += matrix[i][j];
                verticalSum += matrix[j][i];
                if (i == j) mainDiagonalSum += matrix[i][j];
                if ((i + j) == n - 1) antiDiagonalSum += matrix[i][j];
            }
            sumList[i] = horizontalSum;
            sumList[n + i] = verticalSum;
        }
        sumList[2 * n] = mainDiagonalSum;
        sumList[2 * n + 1] = antiDiagonalSum;

        return Arrays.stream(sumList).max().getAsInt();
    }
}
