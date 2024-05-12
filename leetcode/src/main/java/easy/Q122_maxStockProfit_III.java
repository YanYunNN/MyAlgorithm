package easy;

public class Q122_maxStockProfit_III {
    /*
     *给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;
            int[][] dp = new int[len][5]; //dp[i][j] 第i天最大剩余现金；
            /*
             * 定义 5 种状态:
             * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
             */
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0; //买入卖出
            dp[0][3] = -prices[0];
            dp[0][4] = 0; //第二次买入卖出

            for (int i = 1; i < len; i++) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); //不操作或者买入
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]); //不操作或者卖出
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]); //不操作或者买入
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]); //不操作或者卖出
            }
            return dp[len - 1][4];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
