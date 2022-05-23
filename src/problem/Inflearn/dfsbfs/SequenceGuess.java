package problem.Inflearn.dfsbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequenceGuess {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var f = scanner.nextInt();

        new SequenceGuess().solution(n, f);
    }

    private void solution(int n, int f) {
        int[] preNumbers = new int[n];
        for (int i = 0; i < n; i ++) {
            preNumbers[i] = combination(n - 1, i);
        }
        List<Integer> numbers = new ArrayList<>();
        permutation(n, f, new boolean[n], numbers, preNumbers);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", numbers.get(i));
        }
    }

    private int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        else return combination(n - 1, r - 1) + combination(n - 1, r);
    }

    private int permutation(int n, int f, boolean[] selections, List<Integer> numbers, int[] preNumbers) {
        if (numbers.size() == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += numbers.get(i) * preNumbers[i];
            }
            if (sum != f) return 0;
            return 1;
        } else {
            int result = -1;
            for (int i = 0; i < n; i++) {
                if (!selections[i]) {
                    selections[i] = true;
                    numbers.add(i + 1);
                    result = permutation(n, f, selections, numbers, preNumbers);
                    if (result == 1) break;
                    selections[i] = false;
                    numbers.remove(numbers.size() - 1);
                }
            }
            if (result == 1) return 1;
            return 0;
        }
    }
}
