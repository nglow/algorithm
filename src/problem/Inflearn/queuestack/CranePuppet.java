package problem.Inflearn.queuestack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CranePuppet {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(scanner.next());
            }
        }
        var m = Integer.parseInt(scanner.next());
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(scanner.next());
        }

        int dollDisappearedCount = new CranePuppet().solution(n, board, m, moves);

        System.out.println(dollDisappearedCount);
    }

    private int solution(int n, int[][] board, int m, int[] moves) {
        int dollDisappearedCount = 0;
        List<Stack<Integer>> newBoard = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            Stack<Integer> column = new Stack<>();
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    column.push(board[j][i]);
                }
            }
            newBoard.add(column);
        }

        Stack<Integer> bean = new Stack<>();
        for (int i = 0; i < m; i++) {
            var stack = newBoard.get(moves[i] - 1);
            if (stack.isEmpty()) continue;
            var dollPicked = stack.pop();

            if (bean.isEmpty()) {
                bean.push(dollPicked);
                continue;
            }
            var firstDollInBean = bean.peek();

            if (dollPicked == firstDollInBean) dollDisappearedCount += 2;
            else bean.push(dollPicked);
        }

        return dollDisappearedCount;
    }
}
