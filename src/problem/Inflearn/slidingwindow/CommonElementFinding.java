package problem.Inflearn.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommonElementFinding {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        int[] arrayA = new int[n];
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(scanner.next());
        }
        var m = Integer.parseInt(scanner.next());
        int[] arrayB = new int[m];
        for (int i = 0; i < m; i++) {
            arrayB[i] = Integer.parseInt(scanner.next());
        }

        List<Integer> answer = new CommonElementFinding().solution(n, arrayA, m, arrayB);

        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }

    private List<Integer> solution(int n, int[] arrayA, int m, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        var answer = new ArrayList<Integer>();
        int idxA = 0;
        int idxB = 0;
        while (idxA != n && idxB != m) {
            if (arrayA[idxA] == arrayB[idxB]) {
                answer.add(arrayA[idxA]);
                idxA++;
                idxB++;
            } else if (arrayA[idxA] > arrayB[idxB]) idxB++;
            else idxA++;
        }

        return answer;
    }
}
