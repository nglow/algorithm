package graph.directed_graph;

import java.util.ArrayList;
import java.util.Scanner;

public class List {

    public static void main(String[] args) {
        var sc  = new Scanner(System.in);

        var vCnt = Integer.parseInt(sc.next());
        var eCnt = Integer.parseInt(sc.next());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        for (int i = 0; i < vCnt; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < eCnt; i++) {
            var startVertex = sc.nextInt();
            var endVertex = sc.nextInt();
            list.get(startVertex).add(endVertex);
        }

        for (ArrayList<Integer> integers : list) {
            System.out.print("[" + list.indexOf(integers) + "]: ");
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
