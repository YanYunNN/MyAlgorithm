package easy;

public class Q188_maxStockProfit_IV {

    /*
    https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/solutions/577727/javayi-ge-si-lu-da-bao-suo-you-gu-piao-t-pd1p/
     *给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次
     *注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int K, int[] prices) {//这里悄咪咪把小k换成了大K，便于后续索引赋值
            int n = prices.length;
            if (n <= 1) return 0;
            //因为一次交易至少涉及两天，所以如果k大于总天数的一半，就直接取天数一半即可，多余的交易次数是无意义的
            K = Math.min(K, n / 2);

            /*dp定义：dp[i][j][k]代表 第i天交易了k次时的最大利润，其中j代表当天是否持有股票，0不持有，1持有*/
            int[][][] dp = new int[n][2][K + 1];
            for (int k = 0; k <= K; k++) {
                dp[0][0][k] = 0;
                dp[0][1][k] = -prices[0];
            }

        /*状态方程：
        dp[i][0][k]，当天不持有股票时，看前一天的股票持有情况
        dp[i][1][k]，当天持有股票时，看前一天的股票持有情况*/
            for (int i = 1; i < n; i++) {
                for (int k = 1; k <= K; k++) {
                    dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i]); //这里为k是因为卖出，那么已经是第k次交易
                    dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i]); //这里为k-1是因为买出，说明完成了k-1次交易，准备第k次交易
                }
            }
            return dp[n - 1][0][K];//卖出利润更大
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
