package problem.Inflearn.greedy;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(scanner.nextInt() - 1).add(new Edge(scanner.nextInt() - 1, scanner.nextInt()));
        }

        new Dijkstra().solution(n, m, graph);
    }

    private void solution(int n, int m, List<List<Edge>> graph) {
        int[] minCosts = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        minCosts[0] = 0;

        while (!pq.isEmpty()) {
            var poll = pq.poll();
            int now = poll.vertex;
            int nowCost = poll.cost;
            if (nowCost > minCosts[now]) continue;
            for (Edge edge : graph.get(now)) {
                if (minCosts[edge.vertex] > nowCost + edge.cost) {
                    minCosts[edge.vertex] = nowCost + edge.cost;
                    pq.offer(new Edge(edge.vertex, nowCost + edge.cost));
                }
            }
        }

        for (int minCost : minCosts) {
            if (minCost == Integer.MAX_VALUE) System.out.println("No way");
            else System.out.println(minCost);
        }
    }

    static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
