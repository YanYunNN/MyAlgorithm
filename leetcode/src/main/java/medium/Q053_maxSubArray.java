package medium;

public class Q053_maxSubArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    public int maxSubArray(int[] nums) {
        //贪心算法
        int sum = 0, ans = nums[0];
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            ans = Math.max(ans, sum);
            // sum += nums[i]; //贪心 先吃了再说
            // result = max(result, sum);
            // if (sum < 0){   //如果sum < 0，重新开始找子序串
            //     sum = 0;
            // }
        }
        return ans;

    }

    public int maxSubArray1(int[] nums) {
        //标准DP
        int[] dp = new int[nums.length]; //dp[i]为以i为结尾的子序列和的最大值
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if (dp[i - 1] > 0) {
            //     dp[i] = dp[i - 1] + nums[i];
            // } else {
            //     dp[i] = nums[i];
            // }
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
        //优化空间 DP，因为i只与i-1和当前i有关系，可以省去dp new空间
        // int res = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     nums[i] += Math.max(nums[i - 1], 0);
        //     res = Math.max(res, nums[i]);
        // }
        // return res;
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
