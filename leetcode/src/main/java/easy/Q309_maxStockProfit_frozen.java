package base;

public class Q309_maxStockProfit_frozen {
    /*https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/2752587/leetcode-309-zui-jia-mai-mai-gu-piao-shi-ky3v
     *卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
     * */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int dp[][] = new int[len][3]; //i天j状态下的最大现金
        dp[0][0] = 0;//不持股（当天冷冻期）
        dp[0][1] = -prices[0];//持股
        dp[0][2] = 0;//不持股（当天卖出）

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);//前一天不操作或者前一天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//前一天不操作或者前一天是冷冻期，今天买入;
            dp[i][2] = dp[i - 1][1] + prices[i];//前一天持股，今天卖出;
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
