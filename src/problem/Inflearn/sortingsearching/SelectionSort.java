package problem.Inflearn.sortingsearching;

import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        int[] answer =  new SelectionSort().solution(numbers);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }


    private int[] solution(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int min = 101;
            int minIndex = -1;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    minIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }

        return numbers;
    }

}
