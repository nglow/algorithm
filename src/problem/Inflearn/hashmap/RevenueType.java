package problem.Inflearn.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class RevenueType {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = Integer.parseInt(scanner.next());
        var k = Integer.parseInt(scanner.next());
        int[] revenues = new int[n];
        for (int i = 0; i < n; i++) {
            revenues[i] = Integer.parseInt(scanner.next());
        }

        int[] revenueTypeCounts = new RevenueType().solution(n, k, revenues);

        for (int revenueTypeCount : revenueTypeCounts) {
            System.out.print(revenueTypeCount + " ");
        }
    }

    private int[] solution(int n, int k, int[] revenues) {
        int[] revenueTypeCounts = new int[n - k + 1];
        var hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                hashMap.put(revenues[j], 0);
            }
            revenueTypeCounts[i] = hashMap.keySet().size();
            hashMap.clear();
        }

        return revenueTypeCounts;
    }
}
