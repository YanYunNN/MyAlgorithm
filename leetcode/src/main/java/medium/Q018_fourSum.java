package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/11
 * @see <a href=''>Conf<a/>
 *
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class Q018_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            //if (nums[i] >= 0 && nums[i] > target) break; //剪枝
            if (i > 0 && nums[i] == nums[i - 1]) continue; //对第一个元素去重
            for (int j = i + 1; j < nums.length - 2; j++) {
                //if (nums[i] + nums[j] >= 0 && nums[i] + nums[j] > target) break; //剪枝
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; //对第二个元素去重
                long rest = (long) target - nums[i] - nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    long sum = (long) nums[l] + nums[r];
                    if (sum == rest) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++; //对第二个元素去重
                        while (l < r && nums[r] == nums[r - 1]) r--; //对第三个元素去重
                        l++;
                        r--;
                    } else if (sum < rest) l++;
                    else r--;
                }
            }
        }
        return res;
    }
}
