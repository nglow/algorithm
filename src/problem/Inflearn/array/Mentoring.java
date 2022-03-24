package problem.Inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class Mentoring {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());

        int[][] ranksList = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ranksList[i][j] = Integer.parseInt(scanner.next());
            }
        }

        int caseCount = new Mentoring().solution(n, m, ranksList);
        System.out.println(caseCount);
    }

    private int solution(int n, int m, int[][] ranksList) {
        int[][] mentorMentee = new int[n][n];
        for (int[] row : mentorMentee) {
            Arrays.fill(row, 1);
        }

        for (int[] exam : ranksList) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    mentorMentee[exam[i] - 1][exam[j] - 1] = 0;
                }
            }
        }

        int count = 0;
        for (int[] row : mentorMentee) {
            count += Arrays.stream(row).filter(x -> x == 1).count();
        }

        return count - n;
    }
}
