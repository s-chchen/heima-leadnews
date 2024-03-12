package labuladong.Part2动态规划.基本解题思路;


import java.util.Arrays;

/**
 *
 *
 * **/

public class LC00931 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2 ,1, 3},
                {6, 5, 4},
                {7, 8, 9},
        };

        int res = dynamic(arr);
        System.out.println(res);
    }

    private static int dynamic(int[][] arr) {
        int len = arr.length;

        int[][] dp = new int[len][len];
        System.arraycopy(arr[0], 0, dp[0], 0, len);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int mn = arr[i - 1][j];

                if (j > 0) {
                    mn = Math.max(mn, dp[i - 1][j - 1]);
                }
                if (j < len - 1) {
                    mn = Math.min(mn, dp[i - 1][j + 1]);
                }

                dp[i][j] = mn + arr[i][j];
            }
        }

        return Arrays.stream(dp[len - 1]).min().getAsInt();
    }


}
