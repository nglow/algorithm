package problem.jungol;

import java.util.Scanner;

public class P1719 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var n = sc.nextInt();
        var m = sc.nextInt();

        if (n % 2 == 0 || n < 0 || n > 100 || m < 1 || m > 4) {
            System.out.println("INPUT ERROR!");
            return;
        }

        if (m == 1) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }

            for (int i = n / 2 + 1; i < n; i++) {
                for (int j = 0; j < n - i; j++ ) {
                    System.out.print("*");
                }
                if (i != n - 1) System.out.print("\n");
            }
        } else if (m == 2) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("\n");
            }

            for (int i = n / 2 + 1; i < n; i++) {
                for (int j = 0; j < n - i; j++ ) {
                    System.out.print(" ");
                }
                if (i != n - 1) System.out.print("\n");
            }
        }
    }
}
