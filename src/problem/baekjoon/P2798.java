package problem.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P2798 {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        var n = sc.nextInt();
        var m = sc.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int nearestSum = 0;
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    var sum = cards[i] + cards[j] + cards[k];
                    if ( sum <= m && sum > nearestSum) nearestSum = sum;
                }
            }
        }

        System.out.println(nearestSum);
    }
}
