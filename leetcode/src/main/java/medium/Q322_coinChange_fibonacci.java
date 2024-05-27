package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: xcai
 * @date: 2024/05/27
 * @see <a href='https://leetcode.cn/problems/coin-change/solutions/6568/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/'>Conf<a/>
 * 斐波那契数的优化
 */
class Q322_coinChange_fibonacci {
    /**
     * 自顶向下,剪枝备忘录法
     */

    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) continue;
            res = Math.min(res, sub + 1);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo.put(amount, res);
        return res;
    }


    /**
     * 自底向上,DP法
     */
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //为啥 dp 数组初始化为 amount + 1 呢，因为凑成 amount 金额的数最多只可能等于 amount（全用 1 元面值的）
        // 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        //dp[amount] 还是初始值 amount + 1，说明无法凑成该金额，返回 -1。
        //否则，返回 dp[amount]，即凑成 amount 所需的最少硬币数
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}