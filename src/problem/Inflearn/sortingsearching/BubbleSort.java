package problem.Inflearn.sortingsearching;

import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int[] answer =  new BubbleSort().solution(numbers);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbers[j - 1] > numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }

        return numbers;
    }
}
