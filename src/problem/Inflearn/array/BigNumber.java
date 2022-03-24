package problem.Inflearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BigNumber {

    public Integer[] solution(int[] numbers) {
        var numbersBiggerThanBefore = new ArrayList<Integer>();

        numbersBiggerThanBefore.add(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) numbersBiggerThanBefore.add(numbers[i]);
        }

        return numbersBiggerThanBefore.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var N = Integer.parseInt(scanner.next());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        var answer = new BigNumber().solution(numbers);
        for (int number : answer) {
            System.out.print(number + " ");
        }
    }
}
