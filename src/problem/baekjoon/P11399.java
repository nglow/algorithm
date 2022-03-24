package problem.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P11399 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var n = sc.nextInt();

        int[] takeTimes = new int[n];
        for (int i = 0; i < n; i++) {
            takeTimes[i] = sc.nextInt();
        }

        Arrays.sort(takeTimes);

        var sum = 0;
        for (int i = 0; i < takeTimes.length; i++) {
            sum += takeTimes[i] * (takeTimes.length - i);
        }

        System.out.println(sum);
    }
}
