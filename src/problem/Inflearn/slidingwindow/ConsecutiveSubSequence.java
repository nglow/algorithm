package problem.Inflearn.slidingwindow;

import java.util.Scanner;

public class ConsecutiveSubSequence {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var m = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int answer = new ConsecutiveSubSequence().solution(n, m, numbers);
        System.out.println(answer);
    }

    private int solution(int n, int m, int[] numbers) {
        var count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - (i - 1); j++) {
                var sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += numbers[k];
                }
                if (sum == m) count++;
            }
        }

        return count;
    }
}
