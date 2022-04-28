package problem.Inflearn.dfsbfsbasic;

import java.util.Scanner;

// DFS
public class RouteSearch {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var vertexCount = scanner.nextInt();
        var edgeCount = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertexCount][vertexCount];
        for (int i = 0; i < edgeCount; i++) {
            var x = scanner.nextInt();
            var y = scanner.nextInt();
            adjacencyMatrix[x - 1][y - 1] = 1;
        }

        int answer = new RouteSearch().solution(vertexCount, edgeCount, adjacencyMatrix);

        System.out.println(answer);
    }

    private int solution(int vertexCount, int edgeCount, int[][] adjacencyMatrix) {
        int[] visit = new int[vertexCount];
        return dfs(1, vertexCount, adjacencyMatrix, visit);
    }

    private int dfs(int vertex, int vertexCount, int[][] adjacencyMatrix, int[] visit) {
        if (vertex == 5) return 1;
        visit[vertex - 1] = 1;
        int count = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[vertex - 1][i] == 1 && visit[i] != 1){
                count += dfs(i + 1, vertexCount, adjacencyMatrix, visit);
                visit[i] = 0;
            }

        }
        return count;
    }
}
