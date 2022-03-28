package problem.Inflearn.hashmap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassLeader {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var votes = scanner.next();

        char leader = new ClassLeader().solution(n, votes);
        System.out.println(leader);
    }

    private char solution(int n, String votes) {
        var hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < votes.length(); i++) {
            var studentVoted = votes.charAt(i);
//            if (hashMap.get(studentVoted) != null) {
//                var count = hashMap.get(studentVoted);
//                hashMap.put(studentVoted, ++count);
//            } else {
//                hashMap.put(studentVoted, 1);
//            }
            hashMap.put(studentVoted, hashMap.getOrDefault(studentVoted, 0) + 1);
        }

//        int maxValue = 0;
//        char maxKey = '0';
//        var keys = hashMap.keySet();
//        for (Character key : keys) {
//            if (hashMap.get(key) > maxValue) {
//                maxValue = hashMap.get(key);
//                maxKey = key;
//            }
//        }
        var sorted = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors.toList());
        return sorted.get(sorted.size() - 1).getKey();
    }
}
