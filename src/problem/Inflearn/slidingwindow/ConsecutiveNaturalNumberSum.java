package problem.Inflearn.slidingwindow;

import java.util.Scanner;

public class ConsecutiveNaturalNumberSum {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());

        int answer = new ConsecutiveNaturalNumberSum().solution(n);

        System.out.println(answer);
    }

    private int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                int sum = 0;
                for (int k = i; k < i + j; k++) {
                    sum += k;
                }
                if (sum == n) count++;
            }
        }

        return count;
    }
}
