package problem.Inflearn.array;

import java.util.Scanner;

public class ScoreCalculator {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var n = Integer.parseInt(scanner.next());
        int[] examResult = new int[n];
        for (int i = 0; i < n; i++) {
            examResult[i] = Integer.parseInt(scanner.next());
        }

        var score = new ScoreCalculator();
        var answer = score.solution(n, examResult);
        System.out.println(answer);
    }

    private int solution(int n, int[] examResult) {
        int score = 0;
        int cnt = 0;

        for (int result : examResult) {
            if (result == 0) cnt = 0;
            else score += ++cnt;
        }

        return score;
    }
}
