package problem.Inflearn.greedy;

import java.util.*;

public class ConferenceRoomAssignment {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        List<Conference> conferenceList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            conferenceList.add(new Conference(scanner.nextInt(), scanner.nextInt()));
        }

        int answer = new ConferenceRoomAssignment().solution(n, conferenceList);

        System.out.println(answer);

    }

    private int solution(int n, List<Conference> conferenceList) {
        conferenceList.sort(Comparator.naturalOrder());

        List<Integer> conferenceCountList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Stack<Conference> stack = new Stack<>();
            for (int j = i; j < n; j++) {
                if (j == i || stack.peek().endTime <= conferenceList.get(j).startTime)
                    stack.push(conferenceList.get(j));
            }
            conferenceCountList.add(stack.size());
            stack.clear();
        }

        return conferenceCountList.stream().mapToInt(x -> x).max().orElse(-1);
    }

    static class Conference implements Comparable<Conference> {
        private int startTime;
        private int endTime;

        public Conference(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Conference o) {
            return this.startTime - o.startTime;
        }

        private int getStartTime() {
            return this.startTime;
        }

        private int getEndTime() {
            return this.endTime;
        }
    }
}
