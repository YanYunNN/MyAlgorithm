package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q015_threeSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length < 3) return ans;
            int len = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < len; i++) {
                if (nums[i] > 0) break; //排序后第一个>0，则过滤
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
                int left = i + 1;
                int right = len - 1;
                while (left < right) { //双指针移动
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        ans.add(Arrays.asList(nums[i], nums[i], nums[i]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < 0) left++;
                    else right--;
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //对第一个元素去重
            if (nums[i] > 0) break;
            int target = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; //对第二个元素去重
                    while (l < r && nums[r] == nums[r - 1]) r--; //对第三个元素去重
                    l++;
                    r--;
                } else if (sum < target) l++;
                else r--;
            }
        }
        return res;
    }
}
