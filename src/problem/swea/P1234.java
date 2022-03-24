package problem.swea;

import java.util.Scanner;

public class P1234 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        for (int i = 0; i < 1; i++) {
            var n = sc.nextInt();
            var str = sc.next();

            while(true) {
                var index = getDuplicationIndex(str);
                if (index == -1) break;
                str = str.substring(0, index) + str.substring(index + 2);
            }
            System.out.println("#" + (i + 1) + " " + str);
        }
    }

    private static int getDuplicationIndex(String str) {
        for (int j = 0; j < str.length() - 1; j++) {
            if (str.charAt(j) == str.charAt(j + 1)) {
                return j;
            }
        }
        return -1;
    }
}
