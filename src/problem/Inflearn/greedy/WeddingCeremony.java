package problem.Inflearn.greedy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WeddingCeremony {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
//        List<Participant> participants = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            participants.add(new Participant(scanner.nextInt(), scanner.nextInt()));
//        }

//        int answer = new WeddingCeremony().solution(n, participants);

        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(new Time(scanner.nextInt(), "s"));
            times.add(new Time(scanner.nextInt(), "e"));
        }
        int answer = new WeddingCeremony().solution2(n, times);

        System.out.println(answer);

    }

    // Solution 2 (Lecture)
    private int solution2(int n, List<Time> times) {
        Collections.sort(times);
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (Time time : times) {
            if (time.getState().equals("s")) count++;
            else count--;
            if (max < count) max = count;
        }
        return max;
    }

    static class Time implements Comparable<Time> {
        private int time;
        private String state;

        public Time(int time, String state) {
            this.time = time;
            this.state = state;
        }

        public int getTime() {
            return time;
        }

        public String getState() {
            return state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time - o.time == 0) {
                if (this.getState() == "s" && o.getState() == "e") return 1;
                else if (this.getState() == "e" && o.getState() == "s") return -1;
                else return 0;
            }
            return this.time - o.time;
        }
    }

    // Solution 1
    private int solution(int n, List<Participant> participants) {
        Collections.sort(participants);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 72; i++) {
            int count = 0;
            for (Participant participant : participants) {
                if (participant.isInCeremony(i)) count++;
            }
            if (max < count) max = count;
        }

        return max;
    }

    static class Participant implements Comparable<Participant>{
       private int arrivalTime;
       private int departureTime;

        public Participant(int arrivalTime, int departureTime) {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }

        public boolean isInCeremony(int time) {
            return time >= arrivalTime && time < departureTime;
        }

        public int getArrivalTime() {
            return this.arrivalTime;
        }

        public int getDepartureTime() {
            return this.departureTime;
        }

        @Override
        public int compareTo(Participant o) {
            return this.arrivalTime - o.getArrivalTime();
        }
    }
}
