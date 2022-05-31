package problem.Inflearn.greedy;

import java.util.*;

// Priority Queue
public class MaxIncomeSchedule {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lectures.add(new Lecture(scanner.nextInt(), scanner.nextInt()));

        }
        int answer = new MaxIncomeSchedule().solution(n, lectures);

        System.out.println(answer);
    }

    private int solution(int n, List<Lecture> lectures) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.sort(lectures);
        int max = lectures.stream().mapToInt(x -> x.getDueDate()).max().orElse(-1);
        int j = 0;
        int sum = 0;
        for (int i = max; i >= 1; i--) {
            while (lectures.get(j).dueDate == i) {
                queue.offer(lectures.get(j).getIncome());
                if (++j == n) break;
            }
            sum += queue.poll();
        }

        return sum;
    }

    static class Lecture implements Comparable<Lecture> {
        private int income;
        private int dueDate;

        public Lecture(int income, int dueDate) {
            this.income = income;
            this.dueDate = dueDate;
        }

        public int getIncome() {
            return this.income;
        }

        public int getDueDate() {
            return this.dueDate;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.dueDate - this.dueDate;
        }
    }
}
