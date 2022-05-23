package problem.Inflearn.dfsbfs;

import java.util.Scanner;

public class Combination {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();

        new Combination().solution(n, m);
    }

    private void solution(int n, int m) {
        dfs(0, n, m, new boolean[n], -1);
    }

    private void dfs(int level, int n, int m, boolean[] selections, int beforeIndex) {
        if (level == m) {
            for (int i = 0; i < n; i++) {
                if (!selections[i]) continue;
                System.out.printf("%d ", i + 1);
            }
            System.out.println();
        } else {
            for (int i = beforeIndex + 1; i < n; i++) {
                selections[i] = true;
                dfs(level + 1, n, m, selections, i);
                selections[i] = false;
            }
        }
    }
}
