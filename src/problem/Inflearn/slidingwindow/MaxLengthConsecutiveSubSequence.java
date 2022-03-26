package problem.Inflearn.slidingwindow;

import java.util.Scanner;

public class MaxLengthConsecutiveSubSequence {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var m = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int answer = new MaxLengthConsecutiveSubSequence().solution(n, m, numbers);
        System.out.println(answer);
    }

    private int solution(int n, int m, int[] numbers) {

        return 0;
    }
}
