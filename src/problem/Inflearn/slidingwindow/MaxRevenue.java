package problem.Inflearn.slidingwindow;

import java.util.Scanner;

public class MaxRevenue {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var k = Integer.parseInt(scanner.next());
        int[] revenuesInDays = new int[n];
        for (int i = 0; i < n; i++) {
            revenuesInDays[i] = Integer.parseInt(scanner.next());
        }

        int maxRevenueInKDays = new MaxRevenue().solution(n, k, revenuesInDays);

        System.out.println(maxRevenueInKDays);
    }

    private int solution(int n, int k, int[] revenuesInDays) {
        int max = -1;
        for (int i = 0; i < n - k + 1; i++) {
            if (i > 0 && i < n - k) {
                if (revenuesInDays[i - 1] > revenuesInDays[i + k - 1]) continue;
            }
            var revenueInKDays = calculateRevenueInKDays(i, k, revenuesInDays);
            if (revenueInKDays > max) max = revenueInKDays;
        }

        return max;
    }

    private int calculateRevenueInKDays(int idx, int k, int[] revenuesInDays) {
        int sum = 0;
        for (int i = idx; i < idx + k; i++) {
            sum += revenuesInDays[i];
        }

        return sum;
    }
}
