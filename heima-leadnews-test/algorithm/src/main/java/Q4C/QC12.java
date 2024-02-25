package Q4C;

import java.util.Scanner;

public class QC12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] pizzaSizes = new int[N];
        for (int i = 0; i < N; i++) {
            pizzaSizes[i] = sc.nextInt();
        }
        System.out.println(maxPizzaSum(N, pizzaSizes));
    }

    public static long maxPizzaSum(int N, int[] pizzaSizes) {
        if (N == 1) {
            return pizzaSizes[0];
        }
        long[] dp = new long[N];
        dp[0] = pizzaSizes[0];
        dp[1] = Math.max(pizzaSizes[0], pizzaSizes[1]);
        for (int i = 2; i < N - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + pizzaSizes[i], dp[i - 1]);
        }
        return dp[N - 2];
    }

}
