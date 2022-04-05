package problem.Inflearn.queuestack;

import java.util.Scanner;
import java.util.Stack;

public class PostFix {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var postFix = scanner.next();

        int answer = new PostFix().solution(postFix);
        System.out.println(answer);
    }

    private int solution(String postFix) {
        var stack = new Stack<Integer>();
        for (int i = 0; i < postFix.length(); i++) {
            if (Character.isDigit(postFix.charAt(i))) stack.push(Character.getNumericValue(postFix.charAt(i)));
            else {
                var secondNumber = stack.pop();
                var firstNumber = stack.pop();
                var operator = postFix.charAt(i);
                if (operator == '+') stack.push(firstNumber + secondNumber);
                else if (operator == '-') stack.push(firstNumber - secondNumber);
                else if (operator == '*') stack.push(firstNumber * secondNumber);
                else if (operator == '/') stack.push(firstNumber / secondNumber);
            }
        }

        return stack.pop();
    }
}
