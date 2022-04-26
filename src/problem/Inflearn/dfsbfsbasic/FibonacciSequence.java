package problem.Inflearn.dfsbfsbasic;

import java.util.Scanner;

public class FibonacciSequence {
    private int[] memo;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();

        new FibonacciSequence().solution2(n);
    }

    private void solution(int n) {
        int first = 1;
        int second = 1;
        int count = 2;

        System.out.print(first + " ");
        System.out.print(second + " ");
        while (++count <= 10) {
            int result = first + second;
            System.out.print(result + " ");
            first = second;
            second = result;
        }
    }

    // Memoization
    private void solution2(int n) {
        memo = new int[n];
        memo[0] = 1;
        memo[1] = 1;
        System.out.print(memo[0] + " ");
        System.out.print(memo[1] + " ");

        fibonacci(n);
    }

    private int fibonacci(int n) {
        if (memo[n - 1] != 0) return memo[n - 1];
        if (memo[n - 2] == 0) memo[n - 2] = fibonacci(n - 1);
        if (memo[n - 3] == 0) memo[n - 3] = fibonacci(n - 2);

        int result = memo[n - 2] + memo[n - 3];
        System.out.print(result + " ");
        return result;
    }
}
