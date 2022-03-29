package problem.Inflearn.hashmap;

import java.util.Arrays;
import java.util.Scanner;

public class KthBigNumber {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var k = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int kthBitNumber = new KthBigNumber().solution(n, k, numbers);

        System.out.println(kthBitNumber);
    }

    private int solution(int n, int k, int[] numbers) {
        int kthBigNumber = -1;
        Arrays.sort(numbers);
        for (int i = n - 1; i >= 2; i--) {
            for (int j = n - 2; j >= 1; j--) {
                for (int m = n - 3; m >= 0; m--) {
                    if (--k == 0) kthBigNumber = numbers[i] + numbers[j] + numbers[m];
                }
            }
        }

        return kthBigNumber;
    }
}
