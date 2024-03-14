package com.yanyun.leetcode;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/24/20:54
 * @description 买卖股票的最佳时机II
 * 设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。然而，你不能同时参与多个交易（你必须在再次购买前出售股票）
 */
public class _121_maxProfit_II {
    /**
     * 局部最优解：贪心算法
     * 贪心策略：有涨就买
     * @param prices
     * @return
     */
    public static int maxProfit_II(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int max = 0;

        for (int i = 1; i < len; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) max += tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit_II(ints));
    }

}
