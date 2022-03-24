package problem.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class P17413 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var string = sc.nextLine();

        var stack = new Stack<Character>();

        var reverseFlag = true;
        for (int i = 0; i < string.length(); i++) {
            if (reverseFlag) {
                if (string.charAt(i) == '<') {
                    if (!stack.isEmpty()) {
                        printStack(stack);
                    }
                    System.out.print(string.charAt(i));
                    reverseFlag = false;
                } else {
                    if (string.charAt(i) == ' ') {
                        if (stack.empty()) {
                            System.out.print(string.charAt(i));
                            continue;
                        } else {
                            printStack(stack);
                            System.out.print(string.charAt(i));
                            continue;
                        }
                    } else if (i == string.length() - 1) {
                        stack.push(string.charAt(i));
                        printStack(stack);
                        continue;
                    }
                    stack.push(string.charAt(i));
                }

            } else {
                if (string.charAt(i) == '>') {
                    reverseFlag = true;
                }
                System.out.print(string.charAt(i));
            }
        }
    }

    private static void printStack(Stack<Character> stack) {
        while(!stack.isEmpty()) System.out.print(stack.pop());
    }
}
