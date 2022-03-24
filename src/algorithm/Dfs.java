package algorithm;

import java.util.Arrays;

public class Dfs {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {{1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 1}};

        boolean[] visited = new boolean[adjacencyMatrix.length];
        dfs(0, adjacencyMatrix, visited);

        visited = new boolean[adjacencyMatrix.length];
        dfs(3, adjacencyMatrix, visited);
    }

    private static void dfs(int node, int[][] adjacencyMatrix, boolean[] visited) {
        visited[node] = true;
        if (isAllTrue(visited)) System.out.println(node);
        else System.out.print(node + "->");

        for (int i = 0; i < adjacencyMatrix[node].length; i++) {
            if (!visited[i] && adjacencyMatrix[node][i] == 1) {
                dfs(i, adjacencyMatrix, visited);
            }
        }
    }

    private static boolean isAllTrue(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) return false;
        }
        return true;
    }


}
