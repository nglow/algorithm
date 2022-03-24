package problem.Inflearn.string;

import java.util.Scanner;

public class StringCompression {

    public String solution(String str) {
        var sb = new StringBuilder();

        char temp = '0';
        char cnt = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                sb.append(str.charAt(i));
                temp = str.charAt(i);
                continue;
            }

            if (str.charAt(i) == temp) cnt++;
            else {
                temp = str.charAt(i);
                if (cnt != 1) sb.append(Character.forDigit(cnt, 10));
                sb.append(temp);
                cnt = 1;
            }

            if (i == str.length() - 1 && cnt != 1) sb.append(Character.forDigit(cnt, 10));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var str = scanner.next();

        var answer = new StringCompression().solution(str);
        System.out.println(answer);
    }
}
