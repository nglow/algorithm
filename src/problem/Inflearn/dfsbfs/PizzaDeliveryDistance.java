package problem.Inflearn.dfsbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDeliveryDistance {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        new PizzaDeliveryDistance().solution(n, m, board);

    }

    private void solution(int n, int m, int[][] board) {
        // Find pizza house combination
        List<PizzaHouse> pizzaHouses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    pizzaHouses.add(new PizzaHouse(i, j));
                }
            }
        }
        combination(n, m, pizzaHouses, new boolean[pizzaHouses.size()], 0, board, -1);

        System.out.println(minDistance);
    }

    static class PizzaHouse {
        int x;
        int y;

        public PizzaHouse(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void combination(int n, int m, List<PizzaHouse> pizzaHouses, boolean[] visits, int level, int[][] board, int beforeIndex) {
        if (level == m) {
            int sum = calculateClosetDistanceSumOfHouse(n, pizzaHouses, visits, board);
            if (minDistance == -1 || minDistance > sum) minDistance = sum;
        } else {
            for (int i = beforeIndex + 1; i < visits.length; i++) {
                if (!visits[i]) {
                    visits[i] = true;
                    combination(n, m, pizzaHouses, visits, level + 1, board, i);
                    visits[i] = false;
                }
            }
        }
    }

    private int calculateClosetDistanceSumOfHouse(int n, List<PizzaHouse> pizzaHouses, boolean[] visits, int[][] board) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    int min = -1;
                    for (int k = 0; k < visits.length; k++) {
                        if (visits[k]) {
                            int distance = Math.abs(i - pizzaHouses.get(k).x) + Math.abs(j - pizzaHouses.get(k).y);
                            if (min == -1 || min > distance) min = distance;
                        }
                    }
                    sum += min;
                }
            }
        }
        return sum;
    }

    int minDistance = -1;
}
