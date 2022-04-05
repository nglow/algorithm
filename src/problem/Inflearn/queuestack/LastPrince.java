package problem.Inflearn.queuestack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LastPrince {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var princeCount = Integer.parseInt(scanner.next());
        var targetNumber = Integer.parseInt(scanner.next());

        int answer = new LastPrince().solution(princeCount, targetNumber);

        System.out.println(answer);
    }

    private int solution(int princeCount, int targetNumber) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < princeCount; i++) {
            queue.offer(i + 1);
        }

        int temp = 0;
        while (queue.size() != 1) {
            var tempPrince = queue.poll();
            if (++temp != targetNumber) queue.offer(tempPrince);
            else temp = 0;
        }

        return queue.poll();
    }
}
