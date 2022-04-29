package problem.Inflearn.dfsbfsbasic;

import java.util.*;

// BFS
public class GraphShortestPath {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var vertexCount = scanner.nextInt();
        var edgeCount = scanner.nextInt();

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++)
            adjacencyList.add(new ArrayList<>());
        for (int i = 0; i < edgeCount; i++) {
            var x = scanner.nextInt();
            var y = scanner.nextInt();
            adjacencyList.get(x - 1).add(y - 1);
        }

        new GraphShortestPath().solution(vertexCount, edgeCount, adjacencyList);
    }

    private void solution(int vertexCount, int edgeCount, List<List<Integer>> adjacencyList) {
        int[] visits = new int[vertexCount];
        for (int i = 1; i < vertexCount; i++) {
            int level = 0;
            System.out.print(bfs(1, i + 1, adjacencyList, visits) + " ");
        }
    }

    private int bfs(int startNode, int endNode, List<List<Integer>> adjacencyList, int[] visits) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        int level = 0;

        while (!queue.isEmpty()) {
            var size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                var cursor = queue.poll();
                var destinations = adjacencyList.get(cursor - 1);
                for (Integer destination : destinations) {
                    if (destination == endNode - 1) return level;
                    if (visits[destination] != 1) {
                        queue.offer(destination + 1);
                    }
                }
            }
        }

        return -1;
    }
}
