package problem.Inflearn.dfsbfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxScore {

    List<Integer> totalScores = new ArrayList<>();

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();
        int[] scores = new int[n];
        int[] timeLimits = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
            timeLimits[i] = scanner.nextInt();
        }

        int answer = new MaxScore().solution(n, m, scores, timeLimits);

        System.out.println(answer);
    }

    private int solution(int n, int m, int[] scores, int[] timeLimits) {
        dfs(0, n, m, scores, timeLimits, new boolean[n]);

        var sortedTotalScores = totalScores.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return sortedTotalScores.get(sortedTotalScores.size() - 1);
    }

    private void dfs(int level, int n , int m, int[] scores, int[] timeLimits, boolean[] selection) {
        if (level == n) {
            int scoreSum = 0;
            int timeSum = 0;
            for (int i = 0; i < n; i++) {
                if (selection[i]) {
                    scoreSum += scores[i];
                    timeSum += timeLimits[i];
                }
            }
            if (timeSum <= m) totalScores.add(scoreSum);
        } else {
            selection[level] = true;
            dfs(level + 1, n, m, scores, timeLimits, selection);
            selection[level] = false;
            dfs(level + 1, n, m, scores, timeLimits, selection);
        }
    }
}
