package problem.Inflearn.array;

import java.util.Scanner;

public class Peaks {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(scanner.next());
            }
        }

        int peaksCount = new Peaks().solution(n, matrix);
        System.out.println(peaksCount);

    }

    private int solution(int n, int[][] matrix) {
        int peaksCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    if (matrix[i][j] <= matrix[i - 1][j]) continue;
                }
                if (j != 0) {
                    if (matrix[i][j] <= matrix[i][j - 1]) continue;
                }
                if (i != n - 1) {
                    if (matrix[i][j] <= matrix[i + 1][j]) continue;
                }
                if (j != n - 1) {
                    if (matrix[i][j] <= matrix[i][j + 1]) continue;
                }
                peaksCount++;
            }
        }

        return peaksCount;
    }
}
