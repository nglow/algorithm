package problem.Inflearn.sortingsearching;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class LeastRecentlyUsed {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var s = Integer.parseInt(scanner.next());
        var n = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int[] answer = new LeastRecentlyUsed().solution(s, n, numbers);

        Arrays.stream(answer).forEach(x -> System.out.print(x + " "));
    }

    private int[] solution(int s, int n, int[] numbers) {
        int[] cache = new int[s];
        for (int i = 0; i < numbers.length; i++) {
            int index = findIndex(numbers[i], cache);
            if (index == -1) insertNumberToCache(numbers[i], cache, cache.length);
            else insertNumberToCache(numbers[i], cache, index + 1);
        }

        return cache;
    }

    private void insertNumberToCache(int number, int[] cache, int size) {
        for (int i = size - 1; i >= 1; i--) {
            cache[i] = cache[i - 1];
        }
        cache[0] = number;
    }

    private int findIndex(int number, int[] cache) {
        for (int i = 0; i < cache.length; i++) {
            if (number == cache[i]) return i;
        }
        return -1;
    }
}
