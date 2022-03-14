package string;

import java.util.*;

public class RemoveDuplicateCharacter {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var str = scanner.next();
        var answer = new RemoveDuplicateCharacter().solution(str);

        System.out.println(answer);
    }

    public String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer.append(str.charAt(i));
            }
        }

        return answer.toString();
    }
}
