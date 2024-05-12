package easy;

public class Q122_maxStockProfit_II {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        //dp[i][j] 表示到下标为 i 的这一天，持股状态为 j 时，我们手上拥有的最大现金数
        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);//第i天持有现金：前一天不操作或者卖
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//第i天持有股票：前一天持股或者买入
        }
        return dp[len - 1][0];//只有卖出才可能有最大收益
    }

    public int maxProfitII(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        //greedy
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];//只要盈利我就交易
            }
        }
        return res;
    }
}
