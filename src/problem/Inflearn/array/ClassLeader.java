package problem.Inflearn.array;

import java.util.Scanner;

public class ClassLeader {

    public static final int CLASS_COUNT = 5;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[][] matrix = new int[n][CLASS_COUNT];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < CLASS_COUNT; j++) {
                matrix[i][j] = Integer.parseInt(scanner.next());
            }
        }

        int studentNumber = new ClassLeader().solution(n, matrix);
        System.out.println(studentNumber);
    }

    private int solution(int n, int[][] matrix) {
        int[][][] sameClassHistory = new int[n][n][CLASS_COUNT];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < CLASS_COUNT; k++) {
                    if (i == j) continue;
                    if (matrix[i][k] == matrix[j][k]) sameClassHistory[i][j][k] = 1;
                }
            }
        }

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (isSameClass(sameClassHistory[i][j])) count[i]++;
            }
        }

        int max = -1;
        int studentNumber = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                studentNumber = i + 1;
            }
        }
        return studentNumber;
    }

    private boolean isSameClass(int[] sameClassHistories) {
        for (int sameClassHistory : sameClassHistories) {
            if (sameClassHistory == 1) return true;
        }
        return false;
    }
}
