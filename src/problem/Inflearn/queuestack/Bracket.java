package problem.Inflearn.queuestack;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var brackets = scanner.next();

        Answer answer = new Bracket().solution(brackets);

        System.out.println(answer);
    }

    private Answer solution(String brackets) {
        var stack = new Stack<Character>();
        for (int i = 0; i < brackets.length(); i++) {
            var bracket = brackets.charAt(i);
            if (bracket == '(') stack.push(brackets.charAt(i));
            else {
                if (stack.isEmpty()) return Answer.NO;
                else if (stack.pop() == ')') return Answer.NO;
            }
        }

        if (!stack.isEmpty()) return Answer.NO;
        return Answer.YES;
    }

    enum Answer {
        YES, NO
    }
}
