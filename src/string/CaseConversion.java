package string;

import java.util.Arrays;
import java.util.Scanner;

public class CaseConversion {

    public String solution(String str) {
        var chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) chars[i] = Character.toUpperCase(chars[i]);
            else chars[i] = Character.toLowerCase(chars[i]);
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        var caseConversion = new CaseConversion();

        var scanner = new Scanner(System.in);
        var str = scanner.next();

        System.out.println(caseConversion.solution(str));
    }
}
