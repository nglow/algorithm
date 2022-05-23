package problem.Inflearn.dfsbfs;

import java.util.*;

public class MazeTraversal {

    int count = 0;
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int[][] maze = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

//        new MazeTraversal().solution(maze);
//        new MazeTraversal().countPath2(maze);
        new MazeTraversal().findShortestPath(maze);
    }

    private void countPath(int[][] maze) {
        maze[0][0] = 1;
        dfs(maze, 0, 0);
        System.out.println(count);
    }

    private void countPath2(int[][] maze) {
        dfs2(maze, 0, 0);
        System.out.println(count);
    }

    private void findShortestPath(int[][] maze) {
        int shortestPathLength = -1;
        shortestPathLength = bfs(maze, 0, 0, shortestPathLength);
        System.out.println(shortestPathLength);
    }

    private int bfs(int[][] maze, int n, int m, int shortestPathLength) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(new Integer[]{n, m}));
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            for (int i = 0; i < queue.size(); i++) {
                var poll = queue.poll();
                maze[poll.get(0)][poll.get(1)] = 1;
                if (poll.get(0) == 6 && poll.get(1) == 6) {
                    queue.clear();
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int x = poll.get(0) + dx[j];
                    int y = poll.get(1) + dy[j];
                    if (x >= 0 && x <= 6 && y >= 0 && y <=6 && maze[x][y] == 0) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(x);
                        pair.add(y);
                        queue.offer(pair);
                    }
                }
            }
        }

        return length;
    }


    private void dfs(int[][] maze, int n, int m) {
        if (n == 6 && m == 6) count++;
        else {
            for (int i =0 ; i < 4; i++) {
                int x = n + dx[i];
                int y = m + dy[i];
                if (x >= 0 && x <= 6 && y >= 0 && y <=6 && maze[x][y] == 0) {
                    maze[x][y] = 1;
                    dfs(maze, x, y);
                    maze[x][y] = 0;
                }
            }
        }
    }

    private void dfs2(int[][] maze, int n, int m) {
        if (n == 6 && m == 6) count++;
        else if (n >= 0 && n <= 6 && m >= 0 && m <=6 && maze[n][m] == 0) {
            maze[n][m] = 1;
            dfs(maze, n - 1, m);
            dfs(maze, n + 1, m);
            dfs(maze, n, m - 1);
            dfs(maze, n, m + 1);
            maze[n][m] = 0;
        }
    }
}
