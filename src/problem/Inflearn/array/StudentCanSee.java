package problem.Inflearn.array;

import java.util.Scanner;

public class StudentCanSee {

    public int solution(int[] numbers) {
        var max = 0;
        var answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var N = Integer.parseInt(scanner.next());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(scanner.next());
        }

        var answer = new StudentCanSee().solution(numbers);
        System.out.println(answer);
    }
}
