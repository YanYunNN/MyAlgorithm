package greedy;

/**
 * 最大子序和
 * @author xcai
 * @date 2025/02/24
 * @see <a href=''>Conf<a/>
 *
 * @示例
 *输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:  连续子数组  [4,-1,2,1] 的和最大，为  6
 */
public class Q053_maxSubArray {

    /**
     * 滑动窗口通常适用于需要维护窗口内某些属性的情况，比如和大于等于某个值，或者包含所有字符的最短子串。
     * 这类问题可以通过调整窗口的左右边界来优化解。
     * 但最大子数组和的问题不同，它要求找到和最大的连续子数组，而这里没有明确的条件来调整窗口的左右边界
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > res) res = sum;
            if (sum < 0) sum = 0;
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int maxSubArray0(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                res = Math.max(sum, res);
            }
        }
        return res;
    }


}
