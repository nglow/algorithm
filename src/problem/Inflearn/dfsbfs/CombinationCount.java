package problem.Inflearn.dfsbfs;

import java.util.Scanner;

public class CombinationCount {

    int combinationCount = 0;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var r = scanner.nextInt();

//        int answer = new Combination().solution(n, r);
//        System.out.println(answer);

        int answer = new CombinationCount().solution2(n, r);
        System.out.println(answer);
    }

    private int solution(int n, int r) {
        dfs(0, n, r, new boolean[n], -1);
        return combinationCount;
    }

    private void dfs(int count, int n, int r, boolean[] selections, int beforeIndex) {
        if (count == r) {
            combinationCount++;
        } else {
            for (int i = beforeIndex + 1; i < n; i++) {
                if (!selections[i]) {
                    selections[i] = true;
                    dfs(count + 1, n, r, selections, i);
                    selections[i] = false;
                }
            }
        }
    }

    // Memoization
    private int solution2(int n, int r) {
        return dfs2(n, r);
    }

    private int dfs2(int n, int r) {
        if (n == r || r == 0) return 1;
        else return dfs2(n - 1, r - 1) + dfs2(n - 1, r);
    }
}
