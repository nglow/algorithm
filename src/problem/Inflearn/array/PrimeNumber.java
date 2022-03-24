package problem.Inflearn.array;

import java.util.Scanner;

public class PrimeNumber {

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrimeNumber(i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());

        var answer = new PrimeNumber().solution(n);
        System.out.println(answer);
    }
}
