package problem.Inflearn.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int answer = new Island().solution(n, board);

        System.out.println(answer);
    }

    private int solution(int n, int[][] board) {
        int count= 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
//                    dfs(n, board, i, j);
                    bfs(n, board, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int n, int[][] board, int x, int y) {
        board[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && board[nextX][nextY] == 1) {
                dfs(n, board, nextX, nextY);
            }
        }
    }

    private void bfs(int n, int[][] board, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            for (int j = 0; j < queue.size(); j++) {
                var poll = queue.poll();
                board[poll.x][poll.y] = 0;
                for (int i = 0; i < 8; i++) {
                    int nextX = poll.x + dx[i];
                    int nextY = poll.y + dy[i];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && board[nextX][nextY] == 1) {
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
}
