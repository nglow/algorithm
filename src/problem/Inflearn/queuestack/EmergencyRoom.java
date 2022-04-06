package problem.Inflearn.queuestack;

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

        while (!queue.isEmpty()) {
            queue.
        }
    }

}
