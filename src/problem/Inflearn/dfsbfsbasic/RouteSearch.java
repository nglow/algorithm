package problem.Inflearn.dfsbfsbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RouteSearch {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var vertexCount = scanner.nextInt();
        var edgeCount = scanner.nextInt();

        int[][] adjacencyMatrix = new int[vertexCount][vertexCount];
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertexCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            var x = scanner.nextInt();
            var y = scanner.nextInt();
            adjacencyMatrix[x - 1][y - 1] = 1;
            adjacencyList.get(x - 1).add(y - 1);
        }

        int answer = new RouteSearch().solution(vertexCount, adjacencyMatrix);
        System.out.println(answer);

        answer = new RouteSearch().solution2(vertexCount, adjacencyList);
        System.out.println(answer);
    }

    private int solution2(int vertexCount, List<List<Integer>> adjacencyList) {
        int[] visits = new int[vertexCount];
        return dfs(1, vertexCount, adjacencyList, visits);
    }

    private int dfs(int vertex, int vertexCount, List<List<Integer>> adjacencyList, int[] visits) {
        if (vertex == 5) return 1;
        visits[vertex - 1] = 1;
        var edges = adjacencyList.get(vertex - 1);
        return edges.stream()
                .map(x -> {
                    if (visits[x]  != 1) {
                        var value = dfs(x + 1, vertexCount, adjacencyList, visits);
                        visits[x] = 0;
                        return value;
                    }
                    return 0;
                }).mapToInt(Integer::valueOf).sum();
    }

    private int solution(int vertexCount, int[][] adjacencyMatrix) {
        int[] visits = new int[vertexCount];
        return dfs(1, vertexCount, adjacencyMatrix, visits);
    }

    private int dfs(int vertex, int vertexCount, int[][] adjacencyMatrix, int[] visit) {
        if (vertex == 5) return 1;
        visit[vertex - 1] = 1;
        int count = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[vertex - 1][i] == 1 && visit[i] != 1) {
                count += dfs(i + 1, vertexCount, adjacencyMatrix, visit);
                visit[i] = 0;
            }

        }
        return count;
    }
}
