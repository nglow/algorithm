package problem.Inflearn.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePrimeNumber {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        List<Integer> answer;
        var reversePrimeNumber = new ReversePrimeNumber();
        answer = reversePrimeNumber.solution(n, numbers);

        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }

    private List<Integer> solution(int n, int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = reverseInteger(numbers[i]);
            if (isPrimeNumber(temp)) answer.add(temp);
        }
        return answer;
    }

    private boolean isPrimeNumber(int temp) {
        if (temp == 1) return false;
        for (int i = 2; i <= Math.sqrt(temp); i++) {
            if (temp % i == 0) return false;
        }
        return true;
    }

    private int reverseInteger(int number) {
        StringBuilder sb = new StringBuilder();
        var numberStr = String.valueOf(number);
        for (int i = numberStr.length() - 1; i >= 0; i--) {
            sb.append(numberStr.charAt(i));
        }

        return Integer.parseInt(sb.toString());
    }
}
