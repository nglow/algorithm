package problem.Inflearn.string;

import java.util.Scanner;

public class FlipOverPartialWord {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

//        System.out.println((int) 'a'); // 97
//        System.out.println((int) 'z'); // 122
//        System.out.println((int) 'A'); // 65
//        System.out.println((int) 'Z'); // 90

        var str = scanner.next();

        for (int i = str.length() - 1; i >= 0; i--) {
            if (!isSpecialCharacters(str.charAt(i))) System.out.print(str.charAt(i));
            else System.out.print(getOppositeCharacter(str, i));
        }
    }

    private static boolean isSpecialCharacters(char c) {
        if (c > 122) return true;
        else if (c < 97 && c > 90) return true;
        else if (c < 65) return true;

        return false;
    }

    private static char getOppositeCharacter(String str, int i) {
        var length = str.length();
        return str.charAt((length - 1) - i);
    }
}
