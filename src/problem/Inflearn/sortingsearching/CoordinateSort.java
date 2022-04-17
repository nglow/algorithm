package problem.Inflearn.sortingsearching;

import java.util.Arrays;
import java.util.Scanner;

public class CoordinateSort {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());

        int[][] coordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                coordinate[i][j] = Integer.parseInt(scanner.next());
            }
        }

        int[][] answer = new CoordinateSort().solution(n, coordinate);

        Arrays.stream(answer).forEach(x -> {
            Arrays.stream(x).forEach(y -> System.out.print(y + " "));
            System.out.println();
        });
    }

    private int[][] solution(int n, int[][] coordinate) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (coordinate[j][0] > coordinate[j + 1][0]) swap(coordinate, j);
                else if (coordinate[j][0] == coordinate[j + 1][0])
                    if (coordinate[j][1] > coordinate[j + 1][1]) swap(coordinate, j);
            }
        }

        return coordinate;
    }

    private void swap(int[][] coordinate, int j) {
        var tempX = coordinate[j][0];
        var tempY = coordinate[j][1];
        coordinate[j][0] = coordinate[j + 1][0];
        coordinate[j][1] = coordinate[j + 1][1];
        coordinate[j + 1][0] = tempX;
        coordinate[j + 1][1] = tempY;
    }
}
