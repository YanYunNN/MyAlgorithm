package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q090_subsetII {
    public class subsetII {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0) return result;
            Arrays.sort(nums);
            backtrack(nums, 0);
            return result;
        }

        private void backtrack(int[] nums, int start) {
            if (start > nums.length) return;
            result.add(new ArrayList<>(path));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;  //剪枝，跳过当前树层使用过的、相同的元素
                path.add(nums[i]);
                backtrack(nums, i + 1);
                path.removeLast();
            }
        }
    }

    public class subset_used {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0) return result;
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums, 0);
            return result;
        }

        private void backtrack(int[] nums, int start) {
            if (start > nums.length) return;
            result.add(new ArrayList<>(path));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, i + 1);
                path.removeLast();
                used[i] = false;
            }
        }
    }

}
