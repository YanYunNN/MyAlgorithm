package com.yanyun.leetcode;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/24/20:54
 * @description 买卖股票的最佳时机II
 * 设计一个算法来找到最大的利润。你可最多可以买卖俩次。（你必须在再次购买前出售股票）
 */
public class _121_maxProfit_III {

    /**
     * 动态规划
     * @param prices
     * @return 遍历数组，中间点之前有个最大收益，中间点之后有个最大收益，两者相加
     * 两列数组
     */
    public static int maxProfit_III(int[] prices) {
        int len = prices.length, left = 0, res = 0;
        if (prices == null || len <= 1) return 0;

        // maxBack为右侧最大收益DP数组
        int[] max = new int[len];
        int max_right = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max_right = Math.max(max_right, prices[i]);
            max[i] = Math.max(max[i + 1], max_right - prices[i]);
        }

        int min = prices[0];
        for (int i = 0; i < len; i++) {
            min = Math.min(prices[i], min);
            left = Math.max(prices[i] - min, left);
            res = Math.max(left + max[i], res);
        }
        return res;

    }

    public int maxProfit_III_1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp1 = 0;
        int dp2 = 0;
        int min1 = prices[0];
        int min2 = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min1 = Math.min(prices[i] - 0, min1);
            dp1 = Math.max(dp1, prices[i] - min1);

            min2 = Math.min(prices[i] - dp1, min2);
            dp2 = Math.max(dp2, prices[i] - min2);
        }
        return dp2;
    }

    /**
     * 动态规划
     * @param prices
     * @return dp[天数][当前是否持股][卖出的次数]
     */
    public static int maxProfit_III1(int[] prices) {
        int len = prices.length;
        if (prices == null || len <= 1) return 0;
        int[][][] dp = new int[len][2][3];
        int MIN_VALUE = Integer.MIN_VALUE / 2;//因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
        //初始化
        dp[0][0][0] = 0;//第一天休息
        dp[0][0][1] = dp[0][1][1] = MIN_VALUE;//不可能
        dp[0][0][2] = dp[0][1][2] = MIN_VALUE;//不可能
        dp[0][1][0] = -prices[0];//买股票
        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][1][2] = MIN_VALUE;
        }
        return Math.max(0, Math.max(dp[len - 1][0][1], dp[len - 1][0][2]));
    }

    public static void main(String[] args) {
        int[] A = {7, 1, 5, 3, 6, 4};
        int[] B = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit_III(A));
        System.out.println(maxProfit_III(B));
    }

}
