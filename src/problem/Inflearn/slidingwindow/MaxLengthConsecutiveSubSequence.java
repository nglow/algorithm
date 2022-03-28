package problem.Inflearn.slidingwindow;

import java.util.Scanner;

public class MaxLengthConsecutiveSubSequence {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var m = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int answer = new MaxLengthConsecutiveSubSequence().solution(n, m, numbers);
        System.out.println(answer);
    }

    // Two pointers
    private int solution(int n, int m, int[] numbers) {
        int startIndex = 0;
        int endIndex = 0;
        int changeCount = 0;
        int maxLength = 1;
        while (endIndex < n - 1) {
            if (numbers[endIndex] == 0) changeCount++;
            if (changeCount > m) {
                while (changeCount > m) {
                    if (numbers[startIndex] == 0) {
                        changeCount--;
                    }
                    startIndex++;
                }
            }
            int tempLength = endIndex - startIndex + 1;
            if (maxLength < tempLength) maxLength = tempLength;
            endIndex++;
        }

        return maxLength;
    }
}
