package com.yanyun.sword;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/01/05/11:34
 * LIS 最长增长子序列
 */
public class _102_LengthOfLIS {
    /**
     * dp[i] = Math.max(dp[i], dp[j] + 1);
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     */
    public int lengthOfLIS0(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 99, 100};
        int length = lengthOfLIS(arr);
        System.out.println(length);
    }
}
