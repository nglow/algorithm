package problem.Inflearn.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var str1 = scanner.next();
        var str2 = scanner.next();

        Answer answer = new Anagram().solution(str1, str2);
        System.out.println(answer);
    }

    private Answer solution(String str1, String str2) {
        if (str1.length() != str2.length()) return Answer.NO;

        var hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str1.length(); i++) {
            hashMap.put(str1.charAt(i), hashMap.getOrDefault(str1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            hashMap.put(str2.charAt(i), hashMap.getOrDefault(str2.charAt(i), 0) - 1);
        }

        var values = hashMap.values();
        for (Integer value : values) {
            if (value != 0) return Answer.NO;
        }

        return Answer.YES;
    }

    enum Answer {
        YES, NO
    }

}
