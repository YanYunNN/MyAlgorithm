package easy;

public class Q188_maxStockProfit_frozen {

    /*
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。交易次数不限制。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) return 0;
            int[][] dp = new int[prices.length][3];//0持有现金 1冻结 2持有股票
            dp[0][0] = 0;
            dp[0][2] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            int maxProfit = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
            return maxProfit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
