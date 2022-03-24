package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {{1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 1}};

        bfs(0, adjacencyMatrix);

        bfs(3, adjacencyMatrix);
    }

    private static void bfs(int root, int[][] adjacencyMatrix) {
        boolean[] visited = new boolean[adjacencyMatrix.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var number = queue.poll();
            visited[number] = true;
            for (int i = 0; i < adjacencyMatrix[number].length; i++) {
                if (!visited[i] && adjacencyMatrix[number][i] == 1) queue.offer(i);
            }
            if (queue.isEmpty()) System.out.println(number);
            else System.out.print(number + "->");
        }
    }
}
