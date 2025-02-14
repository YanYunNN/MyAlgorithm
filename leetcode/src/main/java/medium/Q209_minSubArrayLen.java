package medium;

/**
 * @author xcai
 * @date 2025/02/07
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class Q209_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int k = Integer.MAX_VALUE;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    k = Math.min(k, j - i + 1);
                    break;
                }
            }
        }
        return k == Integer.MAX_VALUE ? 0 : k;
    }

    /**
     * 窗口内是什么？
     * 如何移动窗口的起始位置？
     * 如何移动窗口的结束位置？
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
