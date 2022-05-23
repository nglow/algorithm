package problem.Inflearn.dfsbfs;

import java.util.*;

// BFS
public class Tomato {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var m = scanner.nextInt();
        var n = scanner.nextInt();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        new Tomato().solution(n, m, board);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void solution(int n, int m, int[][] board) {
        List<Point> startPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    startPoints.add(new Point(i, j));
                }
            }
        }

        var result = bfs(startPoints, board, n, m);

        if (hasNotMaturedTomato(board)) {
            System.out.println("-1");
            return;
        }

        System.out.println(result);
    }

    private boolean hasNotMaturedTomato(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) return true;
            }
        }
        return false;
    }

    private int bfs(List<Point> points, int[][] board, int n, int m) {
        int length = -1;
        Queue<Point> queue = new LinkedList<>();
        for (Point point : points) {
            queue.offer(point);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                var poll = queue.poll();
//                System.out.printf("%d,%d\n", poll.x, poll.y);
                for (int j = 0; j < 4; j++) {
                    var pointToMove = new Point(poll.x + dx[j], poll.y + dy[j]);
                    if (pointToMove.x >= 0 && pointToMove.x < n && pointToMove.y >= 0 && pointToMove.y < m &&
                            (board[pointToMove.x][pointToMove.y] != -1 && board[pointToMove.x][pointToMove.y] != 1)) {
                        board[pointToMove.x][pointToMove.y] = 1;
                        queue.offer(pointToMove);
                    }
                }
            }
            length++;
        }

        return length;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
}
