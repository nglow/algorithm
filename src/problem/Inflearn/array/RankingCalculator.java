package problem.Inflearn.array;

import java.util.Arrays;
import java.util.Scanner;

public class RankingCalculator {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(scanner.next());
        }

        var rankingCalculator = new RankingCalculator();
        int[] ranks = rankingCalculator.solution(scores);

        for (int rank : ranks) {
            System.out.println(rank + " ");
        }
    }

    private int[] solution(int[] scores) {
        int size = scores.length;
        int[] ranks = new int[size];
        Arrays.fill(ranks, 1);

        for (int temp : scores) {
            for (int j = 0; j < size; j++) {
                if (temp > scores[j]) ranks[j]++;
            }
        }

        return ranks;
    }
}
