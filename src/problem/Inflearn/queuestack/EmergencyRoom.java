package problem.Inflearn.queuestack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var m = Integer.parseInt(scanner.next());
        int[] patientRiskScores = new int[n];
        for (int i = 0; i < n; i++) {
            patientRiskScores[i] = Integer.parseInt(scanner.next());
        }

        int answer = new EmergencyRoom().solution(n, m, patientRiskScores);

        System.out.println(answer);
    }

    private int solution(int n, int m, int[] patientRiskScores) {
        Queue<Integer> queue = new LinkedList<>();

        int position = m;
        for (int riskScore : patientRiskScores) {
            queue.offer(riskScore);
        }

        int count = 0;
        int max = getMax(queue);
        while (!queue.isEmpty()) {
            var peek = queue.peek();
            if (peek == max) {
                queue.poll();
                count++;
                if (m == 0) return count;
                max = getMax(queue);
            } else {
                queue.offer(queue.poll());
            }

            if (m - 1 < 0) m = queue.size() - 1;
            else --m;
        }

        return count;
    }

    private int getMax(Queue<Integer> queue) {
        int max = -1;
        for (int i = 0; i < queue.size(); i++) {
            var poll = queue.poll();
            if (poll > max) max = poll;
            queue.offer(poll);
        }
        return max;
    }

}
