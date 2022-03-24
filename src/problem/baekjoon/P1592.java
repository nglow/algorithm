package problem.baekjoon;

import java.util.Scanner;

public class P1592 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var n = sc.nextInt();
        var m = sc.nextInt();
        var l = sc.nextInt();

        int[] arr = new int[n];
        int ballOwner = 0;
        arr[ballOwner]++;
        int cnt = 0;

        while (!isM(arr, n, m)) {
            if (arr[ballOwner] % 2 != 0) {
                ballOwner = (ballOwner + l) % n;
            } else {
                if (ballOwner - l < 0) {
                    ballOwner += (n - l);
                } else {
                    ballOwner = ballOwner - l;
                }
            }
            arr[ballOwner]++;
            cnt++;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        System.out.println(cnt);
    }

    private static boolean isM(int[] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == m) return true;
        }
        return false;
    }
}
