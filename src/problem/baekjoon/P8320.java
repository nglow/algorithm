package problem.baekjoon;

import java.util.Scanner;

public class P8320 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();

        var cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += countNumberOfRectangle(i);
        }

        System.out.println(cnt);
    }

    private static int countNumberOfRectangle(int n) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) cnt++;
        }

        return cnt;
    }
}
