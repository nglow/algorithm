package problem.Inflearn.dfsbfsbasic;

import java.util.Scanner;

// Stack Frame - Data (method arguments, local variable, return address) unit of stack memory
public class RecursiveFunction {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();

        new RecursiveFunction().solution(n);
    }

    private void solution(int n) {
        print(n);
    }

    private void print(int n) {
        if (n != 0) {
            print(n - 1);
            System.out.print(n + " ");
        }
    }
}
