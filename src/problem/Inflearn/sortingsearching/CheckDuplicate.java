package problem.Inflearn.sortingsearching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckDuplicate {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        Result result = new CheckDuplicate().solution2(n, numbers);

        System.out.println(result.toString());
    }

    // O(nLog(n)) ??
    private Result solution2(int n, int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] == numbers[i + 1]) return Result.D;
        }
        return Result.U;
    }

    // O(n)
    private Result solution(int n, int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.get(numbers[i]) == null) map.put(numbers[i], 1);
            else return Result.D;
        }

        return Result.U;
    }



    enum Result {
        D, U
    }

}
