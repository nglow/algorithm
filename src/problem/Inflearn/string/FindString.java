package problem.Inflearn.string;

import java.util.Locale;
import java.util.Scanner;

public class FindString {

    public int solution(String str, char t) {
        int answer = 0;

        var lowerCaseStr = str.toLowerCase(Locale.ROOT);
        var lowerCaseT = Character.toLowerCase(t);

        for (char c : lowerCaseStr.toCharArray()) {
            if (c == lowerCaseT) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        var findString = new FindString();

        var scanner = new Scanner(System.in);
        var str = scanner.next();
        var c = scanner.next().charAt(0);

        System.out.println(findString.solution(str, c));
    }
}
