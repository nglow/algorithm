package string;

import java.util.Scanner;

public class Password {

    public String solution(int n, String password) {
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            var startIndex = 7 * i;
            var endIndex = startIndex + 7;
            var strEncrypted = password.substring(startIndex, endIndex);
            System.out.println(strEncrypted);

            var temp = strEncrypted.replace('#', '1');
            var strDecrypted = temp.replace('*', '0');
            var code = Integer.parseInt(strDecrypted, 2);
            stringBuilder.append((char) code);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var str = scanner.next();

        var answer = new Password().solution(n, str);
        System.out.println(answer);
    }
}
