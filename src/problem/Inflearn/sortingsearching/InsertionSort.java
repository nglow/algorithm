package problem.Inflearn.sortingsearching;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int[] answer =  new InsertionSort().solution(numbers);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int key = numbers[i + 1];
            int keyIndex = i + 1;
            for (int j = i; j >= 0; j--) {
                if (numbers[j] > key) {
                    int temp = numbers[keyIndex];
                    numbers[keyIndex] = numbers[j];
                    numbers[j] = temp;
                    keyIndex = j;
                }
            }
        }

        return numbers;
    }
}
