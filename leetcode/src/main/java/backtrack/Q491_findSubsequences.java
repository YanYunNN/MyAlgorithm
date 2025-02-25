package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q491_findSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return result;
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        if (start > nums.length) return;
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> used = new HashSet<>();//放for循环外，横向剪枝（同层）
        for (int i = start; i < nums.length; i++) {
            //if (i > start && nums[i] == nums[i - 1]) continue;  //剪枝不能这么写 因为没有排序，但不能排序
            if (used.contains(nums[i])) continue;// 用set去重
            if (!path.isEmpty() && path.getLast() > nums[i]) continue; // 保证递增
            used.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
