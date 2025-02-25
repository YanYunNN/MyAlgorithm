package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/20
 * @see <a href=''>Conf<a/>
 * 所有可能的全排列
 * @示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * @示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Q046_permute {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    // 全排列就是求全部的叶子节点
    // 组合问题和排列问题是在树形结构的叶子节点上收集结果，而子集问题就是取树上所有节点的结果。
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) { //不同于子集和组合，排列问题，每次都要从头开始搜索
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
