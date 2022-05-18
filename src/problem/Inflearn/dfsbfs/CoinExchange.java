package problem.Inflearn.dfsbfs;

import java.util.Arrays;
import java.util.Scanner;

public class CoinExchange {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        var m = scanner.nextInt();

        int answer = new CoinExchange().solution(n, coins, m);

        System.out.println(answer);
    }

    private int solution(int n, int[] coins, int m) {
        Arrays.sort(coins);
        return dfs(0, n, coins, m);
    }

    private int dfs(int sum, int n, int[] coins, int m) {
        if (sum == m) {
            return sum;
        } else if (sum > m) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                var result = dfs(sum + coins[n - (i + 1)], n, coins, m);
                if (result == -1) continue;
                return result;
            }
        }

        return -1;
    }
}
