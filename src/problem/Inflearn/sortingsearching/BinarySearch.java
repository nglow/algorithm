package problem.Inflearn.sortingsearching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int answer = new BinarySearch().solution(n, m, numbers);

        System.out.println(answer);
    }

    private int solution(int n, int m, int[] numbers) {
        Arrays.sort(numbers);
        return binarySearch(m, 0, n - 1, numbers) + 1;
    }

    private int binarySearch(int key, int low, int high, int[] numbers) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;

            if (key == numbers[mid])
                return mid;
            else if (key < numbers[mid]) {
                return binarySearch(key, low, mid - 1, numbers);
            } else {
                return binarySearch(key, mid + 1, high, numbers);
            }
        }

        return -1;

    }
}
