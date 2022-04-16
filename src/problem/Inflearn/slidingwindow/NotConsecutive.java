package problem.Inflearn.slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class NotConsecutive {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int[] answer = new NotConsecutive().solution(n, numbers);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private int[] solution(int n, int[] numbers) {
        int[] answer = new int[2];
        Arrays.fill(answer, -1);
        for (int i = 0; i < n - 1; i++) {
            if (answer[0] == -1 && numbers[i] > numbers[i + 1]) answer[0] = i + 1;
            else if (answer[0] != -1 && numbers[i] > numbers[i + 1]) {
                answer[1] = i + 2;
                return answer;
            }
        }

        return answer;
    }
}
