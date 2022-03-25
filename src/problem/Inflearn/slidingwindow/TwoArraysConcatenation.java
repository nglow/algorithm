package problem.Inflearn.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoArraysConcatenation {

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

        var startTime = System.currentTimeMillis();
        List<Integer> answer = new TwoArraysConcatenation().solution2(n, arrayA, m, arrayB);
        var endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        for (Integer number : answer) {
            System.out.print(number + " ");
        }
    }

    // Faster
    private List<Integer> solution(int n, int[] arrayA, int m, int[] arrayB) {
        var answer = new ArrayList<Integer>();

        int idxA = 0;
        int idxB = 0;
        while (idxA != n || idxB != m) {
            if (idxA == n) {
                for (int i = idxB; i < m; i++) {
                    answer.add(arrayB[i]);
                }
                idxB = m;
                continue;
            } else if (idxB == m) {
                for (int i = idxA; i < n; i++) {
                    answer.add(arrayA[i]);
                }
                idxA = n;
                continue;
            }

            if (arrayA[idxA] <= arrayB[idxB]) answer.add(arrayA[idxA++]);
            else answer.add(arrayB[idxB++]);
        }

        return answer;
    }

    private List<Integer> solution2(int n, int[] arrayA, int m, int[] arrayB) {
        var a = Arrays.stream(arrayA).boxed().toArray(Integer[]::new);
        var b = Arrays.stream(arrayB).boxed().toArray(Integer[]::new);
        return Stream.concat(Arrays.stream(a), Arrays.stream(b)).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

}
