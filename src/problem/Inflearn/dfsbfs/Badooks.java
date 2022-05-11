package problem.Inflearn.dfsbfs;

import java.util.Scanner;

public class Badooks {

    private int max = -1;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var c = scanner.nextInt();
        var n = scanner.nextInt();
        int[] weightsOfBadooks = new int[n];
        for (int i = 0; i < n; i++) {
            weightsOfBadooks[i] = scanner.nextInt();
        }

        int answer = new Badooks().solution(c, n, weightsOfBadooks);

        System.out.println(answer);
    }

    private int solution(int c, int n, int[] weightsOfBadooks) {
        dfs(0, c, weightsOfBadooks, new boolean[n]);
        return this.max;
    }

    private void dfs(int level, int c, int[] weights, boolean[] selection) {
        if (level == weights.length) {
            int sum = 0;
            for (int i = 0; i < weights.length; i++) {
                if (selection[i]) sum += weights[i];
            }
            if (sum > c) return;
            else if (this.max < sum) {
                this.max = sum;
//                System.out.println(sum);
            }
        } else {
            selection[level] = true;
            System.out.println(selection[level]);
            dfs(level + 1, c, weights, selection);
            selection[level] = false;
            System.out.println(selection[level]);
            dfs(level + 1, c, weights, selection);
        }
    }
}
