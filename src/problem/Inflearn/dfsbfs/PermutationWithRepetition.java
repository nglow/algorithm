package problem.Inflearn.dfsbfs;

import java.util.Scanner;

public class PermutationWithRepetition {

    int[] result = new int[2];

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();

        new PermutationWithRepetition().solution(n, m);
    }

    private void solution(int n, int m) {

        permutation(0, n, m);
    }

    private void permutation(int count, int n, int m) {
        if (count == m) {
            System.out.print(result[0] + " ");
            System.out.println(result[1]);
        } else {
            for (int i = 0; i < n; i++) {
                result[count] = i + 1;
                permutation(count + 1, n, m);
            }
        }
    }
}
