package base;

public class Q714_maxStockProfit_fee {
    /*https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/2752587/leetcode-309-zui-jia-mai-mai-gu-piao-shi-ky3v
     *卖出股票后，需要收手续费
     * */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;

        int dp[][] = new int[len][2]; //i天j状态下的最大现金
        dp[0][0] = 0;//不持股
        dp[0][1] = -prices[0];//持股

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);//前一天不持股或今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//前一天不持股或今天买入
        }
        return dp[len - 1][0];
    }
}
