package problem.Inflearn.dfsbfs;

import java.util.Scanner;

public class Permutation {

    int[] result = new int[2];

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();

        new Permutation().solution(n, m);
    }

    private void solution(int n, int m) {

        permutationWithRepetition(0, n, m);
        permutationWithNoRepetition(0, n, m, new boolean[n]);
    }

    private void permutationWithRepetition(int count, int n, int m) {
        if (count == m) {
            System.out.print(result[0] + " ");
            System.out.println(result[1]);
        } else {
            for (int i = 0; i < n; i++) {
                result[count] = i + 1;
                permutationWithRepetition(count + 1, n, m);
            }
        }
    }

    private void permutationWithNoRepetition(int count, int n, int m, boolean[] selections) {
        if (count == m) {
            System.out.print(result[0] + " ");
            System.out.println(result[1]);
        } else {
            for (int i = 0; i < n; i++) {
                if (!selections[i]) {
                    result[count] = i + 1;
                    selections[i] = true;
                    permutationWithNoRepetition(count + 1, n, m, selections);
                    selections[i] = false;
                }
            }
        }
    }
}
