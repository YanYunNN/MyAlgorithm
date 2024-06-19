package medium;

import java.util.Arrays;

/**
 * @author xcai
 * @date 2024/06/19
 * @see <a href='https://leetcode.cn/problems/house-robber-ii/solutions/28258/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/'>Conf<a/>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * <p>
 * 环状排列 意味着第一个房子和最后一个房子中 只能选择一个偷窃，因此可以把此 环状排列房间 问题约化为两个 单排排列房间 子问题：
 * 在不偷窃第一个房子的情况下（即 nums[1:]），最大金额是 p1
 * 在不偷窃最后一个房子的情况下（即 nums[:n−1]），最大金额是 p2
 * <p>
 * 综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)max(p1,p2)max(p1,p2) 。
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode.cn/problems/house-robber-ii/solutions/28258/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q198_dp_robII_213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob1(Arrays.copyOfRange(nums, 0, nums.length - 1)), rob1(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int rob1(int[] nums) {
        int[] dp = new int[2]; //dp[0] dp[1]
        for (int num : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            int tmp = Math.max(dp[1], dp[0] + num);
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return dp[1];
    }
}
