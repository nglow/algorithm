package problem.Inflearn.greedy;

import java.util.*;

// 씨름
public class SeeRm {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        List<Player> players =  new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(scanner.nextInt(), scanner.nextInt()));
        }

        int answer = new SeeRm().solution(n, players);

        System.out.println(answer);
    }

    private int solution(int n, List<Player> players) {
        int count = 0;
        players.sort(Comparator.naturalOrder());
        int max = Integer.MIN_VALUE;
        for (Player player : players) {
            if (player.weight > max) {
                max = player.weight;
                count++;
            }
        }

        return count;
    }

    static class Player implements Comparable<Player> {
        int height, weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player o) {
            return o.height - this.height;
        }
    }
}
