package problem.Inflearn.dfsbfsbasic;

import java.util.Scanner;

public class Subset {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();

        new Subset().solution(n);
    }

    private void solution(int n) {
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = i + 1;
//        }
//        powerSet(numbers, 0, new boolean[n]);
        dfs(0, n, new boolean[n]);
    }

    private void dfs(int level, int n, boolean[] selection) {
        if (level == n) {
            for (int i = 0; i < n; i++) {
                if (selection[i])
                    System.out.print((i + 1) + " ");
            }
            System.out.println();
        } else {
            selection[level] = true;
            dfs(level + 1, n, selection);
            selection[level] = false;
            dfs(level + 1, n, selection);
        }
    }

    private void powerSet(int[] numbers, int index, boolean[] selection) {
        if (index == numbers.length) {
            for (int i = 0; i < selection.length; i++) {
                if (selection[i])
                    System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        selection[index] = true;
        powerSet(numbers, index + 1, selection);
        selection[index] = false;
        powerSet(numbers, index + 1, selection);
    }
}
