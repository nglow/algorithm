package problem.Inflearn.dfsbfsbasic;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();

        new DecimalToBinary().solution(n);
    }

    private void solution(int n) {
        dfs(n);
    }

    private void dfs(int n) {
        if (n != 0) {
            dfs(n / 2);
            System.out.print(n % 2 + " ");
        }
    }
}
