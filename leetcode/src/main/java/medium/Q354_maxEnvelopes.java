package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://labuladong.online/algo/dynamic-programming/longest-increasing-subsequence-2
 */
public class Q354_maxEnvelopes {
    // envelopes = [[w, h], [w, h]...]
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) return 0;
        int n = envelopes.length;
        //对宽度 w 从小到大排序，确保了 w 这个维度可以互相嵌套，所以我们只需要专注高度 h 这个维度能够互相嵌套即可。
        //其次，两个 w 相同的信封不能相互包含，所以对于宽度 w 相同的信封，对高度 h 进行降序排序
        //保证二维 LIS 中不存在多个 w 相同的信封（因为题目说了长宽相同也无法嵌套）
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLTS(height);
    }

    public int lengthOfLTS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
