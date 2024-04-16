package cch.dongtaiguihua;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * */
public class Lc0322 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{1, 2, 5};
        int amounts = 11;
        int re = solution.coinChange(coins, amounts);
        System.out.println(re);
    }

}


/**
 * 动态规划
 * F（i） = F（i - coin） + 1
 */
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int j = 0; j < coins.length; j++) {
                int c = coins[j];
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}