package medium;

import java.util.HashMap;
import java.util.Map;

public class Q001_twoSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums == null || nums.length < 2) return ans;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return ans;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(v)};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
//leetcode submit region end(Prohibit modification and deletion)
}
