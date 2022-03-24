package problem.baekjoon;

import java.util.Scanner;

public class P1523 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var n = Integer.parseInt(sc.nextLine());

        var cnt = 0;
        var result = 0;
        for (int i = 0; i < n; i++) {
            var str = sc.nextLine();
            cnt = 0;
            for (int j = 0; j < n; j++) {
                var value = str.charAt(j);
                if (value == '1') cnt++;
            }
            if (cnt == 1) result++;
        }

        System.out.print(result);
    }
}
