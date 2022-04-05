package problem.Inflearn.queuestack;

import java.util.Scanner;
import java.util.Stack;

public class IronStick {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var input = scanner.next();

        int answer = new IronStick().solution(input);
        System.out.println(answer);
    }

    private int solution(String input) {
        int answer = 0;
        int maxDepth = 0;
        int depth = 0;
        var stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                if (stack.isEmpty()) stack.push(input.charAt(i));
                else if (stack.peek() == '(') {
                    if (maxDepth < ++depth) maxDepth = depth;
                    stack.push(input.charAt(i));
                } else if (stack.peek() == ')') stack.push(input.charAt(i));
            }
            else if (input.charAt(i) == ')') {
                if (stack.isEmpty()) continue;
                else if (stack.peek() == ')') depth--;
                else if (stack.peek() == '(') {
                    answer += depth;
                }
            }
        }

        return answer;
    }
}
