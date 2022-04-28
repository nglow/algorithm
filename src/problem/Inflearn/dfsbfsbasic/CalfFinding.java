package problem.Inflearn.dfsbfsbasic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// State Tree Search
public class CalfFinding {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var s = scanner.nextInt();
        var e = scanner.nextInt();

//        int answer = new CalfFinding().solution(s, e);
        int answer = new CalfFinding().solution2(s, e);

        System.out.println(answer);
    }

    private int solution(int s, int e) {
        int distance = Math.abs(s - e);

        int quotient = distance / 5;
        int remainder = distance % 5;
        if (remainder == 0) return quotient;
        else {
            if (remainder >= 5 / 2) return quotient + 1 + (5 - remainder);
            else return quotient + remainder;
        }
    }

    private int solution2(int s, int e) {
        return bfs(s, e);
    }

    private int bfs(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int level = 0;

        while(!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var cursor = queue.poll();
                if (cursor == e) return level;
                else {
                    queue.offer(cursor - 1);
                    queue.offer(cursor + 1);
                    queue.offer(cursor + 5);
                }
            }
            level++;
        }

        return -1;
    }
}
