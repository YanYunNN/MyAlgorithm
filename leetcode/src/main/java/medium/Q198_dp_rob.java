package medium;

/**
 * @author xcai
 * @date 2024/06/19
 * @see <a href='https://leetcode.cn/problems/house-robber/solutions/138131/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap'>Conf<a/>
 * 输入：[2,7,9,3,1]
 * 输出：12
 */
public class Q198_dp_rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len + 1]; //增加0没有房子的case
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev = 0;
        int curr = 0;
        for (int num : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            int tmp = Math.max(curr, prev + num);
            prev = curr;
            curr = tmp;
        }
        return curr;
    }
}
