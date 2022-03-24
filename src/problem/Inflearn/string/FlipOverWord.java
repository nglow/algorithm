package problem.Inflearn.string;

import java.util.Scanner;

public class FlipOverWord {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var N = Integer.parseInt(scanner.next());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = scanner.next();
        }

        for (int i = 0; i < N; i++) {
            for (int j = words[i].length() - 1; j >= 0; j--) {
                System.out.print(words[i].charAt(j));
            }
            System.out.println();
        }
    }
}
