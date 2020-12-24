package com.yanyun.sword;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/17/19:36
 * @description [算法]
 * 给定一个矩阵m*n，从左上角开始每次只能向右或者向下走，最后到右下角的位置共有多少种路径
 * 美团面试题变体：m*n矩阵，从左上角走到右下角，向右走和向下走视为正向，反之视为负向。每个格子有无限次正向走的机会，一次负向走的机会。请打印出所有可行路径。
 * <p>
 * ====================================================================================================================
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class _ctm_uniquePaths {
    /**
     * 动态规划方案：
     * dp[i][j]=dp[i-1][j]+dp[i][j-1]
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    //上一次的结果，再向右，向下
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * C (m-1)+(n-1) ,m-1 总共m+n-2中走法，随机组合m-1
     * (m+n-2)!/(m-1)!
     */
    public static int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans *= x / y;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int i = uniquePaths(3, 2);
        int j = uniquePaths1(3, 2);
        System.out.println(i);
        System.out.println(j);
    }
}
