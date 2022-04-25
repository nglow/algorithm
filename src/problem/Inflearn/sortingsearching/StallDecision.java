package problem.Inflearn.sortingsearching;

import java.util.Arrays;
import java.util.Scanner;

public class StallDecision {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var c = scanner.nextInt();
        int[] coordinates = new int[n];
        for (int i = 0; i < n; i++) {
            coordinates[i] = scanner.nextInt();
        }

        int answer = new StallDecision().solution(n, c, coordinates);

        System.out.println(answer);
    }

    private int count(int[] coordinates, int distance) {
        int count = 1;
        int endPoint = coordinates[0];

        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i] - endPoint >= distance) {
                count++;
                endPoint = coordinates[i];
            }
        }

        return count;
    }

    private int solution(int n, int c, int[] coordinates) {
        int answer = 0;
        Arrays.sort(coordinates);
        int left = 1;
        int right = coordinates[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (count(coordinates, mid) >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
