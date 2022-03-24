package problem.swea;

import java.util.Scanner;

public class P2805 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            var n = sc.nextInt();
            var sum = 0;

            for (int j = 0; j <= n / 2; j++) {
                var s = sc.next();
                for (int k = n / 2 - j; k <= n/2 + j ; k++) {
                    sum += s.charAt(k) - '0';
                }
            }

            for (int j = n / 2 + 1; j < n; j++) {
                var s = sc.next();
                for (int k = j - n / 2; k < n - (j - n / 2) ; k++) {
                    sum += s.charAt(k) - '0';
                }
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
