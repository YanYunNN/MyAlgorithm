package medium;

import java.util.Arrays;

/**
 * 最长递增子序列
 * like：Q354 俄罗斯套娃信封（二维）
 * https://labuladong.online/algo/dynamic-programming/longest-increasing-subsequence-2
 */
public class Q300_lengthOfLTS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];//以每个元素为末尾的最长递增子序列的长度
        Arrays.fill(dp, 1);
        int res = 1;

        //n^2
        for (int i = 0; i < nums.length; i++) {//遍历dp数组
            for (int j = 0; j < i; j++) {
                ////找到前面那些结尾比num[i]小的子序列，然后把 num[i]接到这些子序列末尾，就可以形成一个新的递增子序列，而且这个新的子序列长度加一
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(dp[i], res);
            }
        }
        return res;

    }

}
