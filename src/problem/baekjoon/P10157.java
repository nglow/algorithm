package problem.baekjoon;

import java.util.Scanner;

public class P10157 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var m = sc.nextInt();
        var targetNumber = sc.nextInt();

        if (n * m < targetNumber) {
            System.out.println(0);
            return;
        }

        var cnt = 0;
        int[][] visit = new int[n][m];
        int[] result = new int[2];
        System.out.println(move(0, 0, n - 1, m - 1, visit, cnt, targetNumber));

//        for (int i = 0; i < visit.length; i++) {
//            for (int j = 0; j < visit[i].length; j++) {
//                System.out.print(visit[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static String move(int x, int y, int n, int m, int[][] visit, int cnt, int targetNumber) {
        visit[x][y] = 1;
        cnt++;
        if (cnt == targetNumber) {
            return (x + 1) + " " + (y + 1);
        }
//        System.out.println(cnt);
        if ((x - 1 < 0 || visit[x- 1][y] == 1) && (y + 1 <= m && visit[x][y + 1] != 1))
            return move(x, y + 1, n, m, visit, cnt, targetNumber);
        else if ((y + 1 > m || visit[x][y + 1] == 1) && (x + 1 <= n && visit[x + 1][y] != 1))
            return move(x + 1, y, n, m, visit, cnt, targetNumber);
        else if ((x + 1 > n || visit[x + 1][y] == 1) && (y - 1 >= 0 && visit[x][y - 1] != 1))
            return move(x, y - 1, n, m, visit, cnt, targetNumber);
        else if ((y - 1 < 0 || visit[x][y - 1] == 1) && (x - 1 >= 0 && visit[x - 1][y] != 1)){
            return move(x - 1, y, n, m, visit, cnt, targetNumber);
        }

        return null;
    }
}
