package problem.Inflearn.sortingsearching;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var m = scanner.nextInt();
        int[] songs = new int[n];
        for (int i = 0; i < n; i++) {
            songs[i] = scanner.nextInt();
        }

        int minimumDvdCapacity = new MusicVideo().solution(n, m, songs);

        System.out.println(minimumDvdCapacity);
    }

    private int solution(int n, int m, int[] songs) {
        int answer = 0;
        int left = Arrays.stream(songs).max().getAsInt();
        int right = Arrays.stream(songs).sum();

        while(left <= right) {
            int mid = (left + right) / 2;

            if (countDvds(songs, mid) <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private int countDvds(int[] songs, int capacity) {
        int sum = 0;
        int count = 0;
        for (int song : songs) {
           sum += song;
           if (sum > capacity) {
               sum = song;
               count++;
           }
        }

        return ++count;
    }
}
