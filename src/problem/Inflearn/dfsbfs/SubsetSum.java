package problem.Inflearn.dfsbfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SubsetSum {

    Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Answer answer = new SubsetSum().solution(n, numbers);

        System.out.println(answer.toString());
    }

    private Answer solution(int n, int[] numbers) {
        var answer = dfs(0, numbers, new boolean[n]);
        if (answer) return Answer.NO;
        return Answer.YES;
    }

    private boolean dfs(int level, int[] numbers, boolean[] selection) {
        if (level == numbers.length) {
            int sum = 0;
            for (int i = 0; i < selection.length; i++) {
                if (selection[i]) {
                    sum += numbers[i];
                }
            }
            if (map.get(sum) == null) {
                map.put(sum, true);
                return true;
            }
            return false;
        } else {
            selection[level] = true;
            var answer1 = dfs(level + 1, numbers, selection);
            selection[level] = false;
            var answer2 = dfs(level + 1, numbers, selection);
            return answer1 && answer2;
        }
    }


    enum Answer {
        YES, NO
    }
}
