package problem.Inflearn.queuestack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DeletingCharactersInBrackets {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var str = scanner.next();

        String answer = new DeletingCharactersInBrackets().solution(str);

        System.out.println(answer);
    }

    private String solution(String str) {
        var answerBuilder = new StringBuilder();
        var stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            if (c == '(') stack.push(c);
            else if (c == ')') stack.pop();
            else if (stack.isEmpty()) answerBuilder.append(c);
        }

        return answerBuilder.toString();
    }
}
