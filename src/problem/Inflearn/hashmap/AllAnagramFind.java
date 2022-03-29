package problem.Inflearn.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class AllAnagramFind {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var s = scanner.next();
        var t = scanner.next();

        int anagramCount = new AllAnagramFind().solution(s, t);

        System.out.println(anagramCount);
    }

    private int solution(String s, String t) {
        var anagramCount = 0;
        var sLength = s.length();
        var tLength = t.length();
        for (int i = 0; i < sLength - tLength + 1; i++) {
            var hashMap = new HashMap<Character, Integer>();
            for (int j = i; j < i + tLength; j++) {
                hashMap.put(s.charAt(j), hashMap.getOrDefault(s.charAt(j), 0) + 1);
            }
            for (int j = 0; j < tLength; j++) {
                if (hashMap.get(t.charAt(j)) == null) break;
                else {
                    hashMap.put(t.charAt(j), hashMap.get(t.charAt(j)) - 1);
                }
            }
            if (isAnagram(hashMap)) anagramCount++;
        }
        return anagramCount;
    }

    private boolean isAnagram(HashMap<Character, Integer> hashMap) {
        var values = hashMap.values();
        for (Integer value : values) {
            if (value != 0) return false;
        }
        return true;
    }
}
