package problem.Inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 씨름
public class SeeRm {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        int[][] players = new int[n][2];
        for (int i = 0; i < n; i++) {
            players[i][0] = scanner.nextInt();
            players[i][1] = scanner.nextInt();
        }

        int answer = new SeeRm().solution(n, players);

        System.out.println(answer);
    }

    private int solution(int n, int[][] players) {
        boolean[] failCheckList = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (players[i][0] < players[j][0] && players[i][1] < players[j][1]) {
                    failCheckList[i] = true;
                    break;
                }
            }
        }

        return countPass(failCheckList);
    }

    private int countPass(boolean[] failCheckList) {
        int count = 0;
        for (boolean isFail : failCheckList) {
            if (!isFail) count++;
        }

        return count;
    }
}
