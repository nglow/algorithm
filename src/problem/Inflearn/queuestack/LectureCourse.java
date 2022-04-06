package problem.Inflearn.queuestack;

import java.util.*;

public class LectureCourse {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var courseRule = scanner.next();
        var demoCourse = scanner.next();

        Answer answer = new LectureCourse().solution(courseRule, demoCourse);

        System.out.println(answer);
    }

    private Answer solution(String courseRule, String demoCourse) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < courseRule.length(); i++) {
            queue.offer(courseRule.charAt(i));
        }

        for (int i = 0; i < demoCourse.length(); i++) {
            if (queue.isEmpty()) break;

            var peek = queue.peek();
            if (peek == demoCourse.charAt(i)) queue.poll();
        }

        if (queue.isEmpty()) return Answer.YES;
        return Answer.NO;
    }

    enum Answer {
        YES, NO
    }
}
