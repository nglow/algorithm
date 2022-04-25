package problem.Inflearn.dfsbfsbasic;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();

        int answer = new Factorial().solution(n);

        System.out.println(answer);
    }

    private int solution(int n) {
        return multiply(n);
    }

    private int multiply(int n) {
        if (n != 1) {
            return n * multiply(n - 1);
        } else return 1;
    }
}
