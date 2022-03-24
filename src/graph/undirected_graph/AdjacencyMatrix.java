package graph.undirected_graph;

import java.util.Scanner;

public class AdjacencyMatrix {

    public static void main(String[] args) {
        var sc  = new Scanner(System.in);

        var vCnt = sc.nextInt();
        var eCnt = sc.nextInt();

        int[][] matrix = new int[vCnt + 1][vCnt + 1];

        for (int i = 0; i < eCnt; i++) {
            var startVertex = sc.nextInt();
            var endVertex = sc.nextInt();
            matrix[startVertex][endVertex] = 1;
            matrix[endVertex][startVertex] = 1;
        }

        for (int i = 1; i <= vCnt; i++) {
            System.out.print("[" + i + "]: ");
            for (int j = 1; j <= vCnt; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
