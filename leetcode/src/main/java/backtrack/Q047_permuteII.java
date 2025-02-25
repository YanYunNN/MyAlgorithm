package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/20
 * @see <a href=''>Conf<a/>
 *给定一个可包含重复数字的序列，要返回所有不重复的全排列不重复的全排列
 * @示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * @示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Q047_permuteII {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return result;
        used = new boolean[nums.length];
        Arrays.sort(nums); //先排序，让重复元素相邻
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) { //不同于子集和组合，排列问题，每次都要从头开始搜索
            // 如果要对树层中前一位去重，就用used[i - 1] == false,效率更高
            // 如果要对树枝前一位去重用used[i - 1] == true
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
