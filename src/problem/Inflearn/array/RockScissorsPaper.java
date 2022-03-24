package problem.Inflearn.array;

import java.util.Scanner;

public class RockScissorsPaper {

    public char[] solution(int n, int[] a, int[] b) {
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer[i] = 'D';
            else if (a[i] - b[i] == 1 || a[i] - b[i] == -2) answer[i] = 'A';
            else if (a[i] - b[i] == -1 || a[i] - b[i] == 2) answer[i] = 'B';
        }

        return answer;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(scanner.next());
        }
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(scanner.next());
        }

        var answer = new RockScissorsPaper().solution(n, a, b);

        for (char c : answer) {
            System.out.println(c);
        }
    }

}
