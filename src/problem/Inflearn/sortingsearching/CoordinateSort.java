package problem.Inflearn.sortingsearching;

import java.util.*;

public class CoordinateSort {

    static class Coordinate implements Comparable<Coordinate> {
        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        @Override
        public int compareTo(Coordinate o) {
            var valueX = this.getX() - o.getX();
            if (valueX != 0) return valueX;
            else return this.getY() - o.getY();
        }
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());

//        int[][] coordinate = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                coordinate[i][j] = Integer.parseInt(scanner.next());
//            }
//        }
//
//        int[][] answer = new CoordinateSort().solution(n, coordinate);

//        Arrays.stream(answer).forEach(x -> {
//            Arrays.stream(x).forEach(y -> System.out.print(y + " "));
//            System.out.println();
//        });

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            var x = scanner.nextInt();
            var y = scanner.nextInt();
            coordinates.add(new Coordinate(x, y));
        }

        List<Coordinate> answer = new CoordinateSort().solution2(n, coordinates);

        answer.forEach(coordinate -> {
            System.out.print(coordinate.getX() + " ");
            System.out.print(coordinate.getY() + "\n");
        });



    }

    private List<Coordinate> solution2(int n, List<Coordinate> coordinates) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n - 1 - i; j++) {
//                if (coordinates.get(j).compareTo(coordinates.get(j + 1)) > 0) {
//                    var temp = coordinates.get(j);
//                    coordinates.set(j, coordinates.get(j + 1));
//                    coordinates.set(j + 1, temp);
//                }
//            }
//        }
        coordinates.sort(Comparator.naturalOrder());

        return coordinates;
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
