package string;

import java.util.Locale;
import java.util.Scanner;

public class Palindrome {

    public String solution(String str) {
        var lowerCaseStr = str.toLowerCase();
        for (int i = 0; i < lowerCaseStr.length() / 2; i++) {
            if (Character.isAlphabetic(lowerCaseStr.charAt(i)) && lowerCaseStr.charAt(i) != lowerCaseStr.charAt((lowerCaseStr.length() - 1) - i)) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var str = scanner.nextLine();

        var answer = new Palindrome().solution(str);

        System.out.println(answer);
    }
}
