package com.yanyun.leetcode;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/24/20:54
 * @description 买卖股票的最佳时机
 */
public class _121_maxProfit {
    /**
     * 动态规划算法
     * 用dp[i]表示第i天卖出的收益，则dp[i]=max(price[i]-min,maxProfit)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) min = prices[i];
            else max = Math.max(prices[i] - min, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ints));
    }

}
