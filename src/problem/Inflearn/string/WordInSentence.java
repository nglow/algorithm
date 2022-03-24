package problem.Inflearn.string;

import java.util.Scanner;

public class WordInSentence {

    public String solution(String str) {
        int maxLength = -1;
        String answer = "";

        var words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= maxLength) {
                maxLength = words[i].length();
                answer = words[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        var wordInSentence = new WordInSentence();

        var scanner = new Scanner(System.in);
        var str = scanner.nextLine();

        System.out.println(wordInSentence.solution(str));
    }
}
