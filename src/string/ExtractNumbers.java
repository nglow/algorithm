package string;

import java.util.Scanner;

public class ExtractNumbers {

    public String solution(String str) {
        var answer = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (answer.length() == 0) {
                if (c != '0' && Character.isDigit(c)) answer.append(c);
            } else {
                if (Character.isDigit(c)) answer.append(c);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var str = scanner.next();

        var answer = new ExtractNumbers().solution(str);
        System.out.println(answer);
    }
}
