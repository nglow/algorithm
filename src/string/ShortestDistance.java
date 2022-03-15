package string;

import java.util.Scanner;

public class ShortestDistance {

    public int[] solution(String str, char c) {
        int[] answer = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                answer[i] = 0;
                continue;
            }

            var leftClosestCIndex = str.substring(0, i).lastIndexOf(c);
            var rightClosetCIndex = str.substring(i + 1).indexOf(c);
            int leftClosetDistance = 100;
            int rightClosetDistance = 100;
            if (leftClosestCIndex != -1) leftClosetDistance= i - leftClosestCIndex;
            if (rightClosetCIndex != -1) rightClosetDistance = rightClosetCIndex + 1;

            answer[i] = Math.min(leftClosetDistance, rightClosetDistance);
        }

        return answer;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var str = scanner.next();
        var c = scanner.next().charAt(0);

        var answer = new ShortestDistance().solution(str, c);

        for (int distance : answer) {
            System.out.print(distance);
            System.out.print(' ');
        }
    }

}
