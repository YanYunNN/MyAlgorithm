package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xcai
 * @date: 2024/06/04
 * @see <a href=''>Conf<a/>
 * 给你输入 candidates 和一个目标和 target，从 candidates 中找出中所有和为 target 的组合。
 * candidates 可能存在重复元素，且其中的每个数字最多只能使用一次
 * 输入 candidates = [1,2,3], target = 3
 * 输出 [ [1,1,1],[1,2],[3] ]
 */
public class Q040_traverse_combinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return null;
        // 先排序，让相同的元素靠在一起
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int start, int target) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        // base case，超过目标和，直接结束
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;//跳过排序相邻且重复，剪枝
            track.add(nums[i]);
            trackSum += nums[i];
            backtrack(nums, i + 1, target);
            trackSum -= nums[i];
            track.removeLast();
        }
    }
}
