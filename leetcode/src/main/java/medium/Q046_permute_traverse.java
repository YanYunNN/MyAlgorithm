package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * backtrack
 * @see <a href='https://labuladong.online/algo/essential-technique/backtrack-framework/'>Link<a/>
 * @see <a href='@see <a href='https://labuladong.online/algo/essential-technique/backtrack-framework/'>Link<a/>'>Link<a/>
 *
 */
public class Q046_permute_traverse {
    public class Solution1 {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            List<Integer> track = new ArrayList<>();
            //「路径」中的元素会被标记为 true，避免重复使用
            boolean[] used = new boolean[nums.length];
            backtrack(nums, track, used);
            return res;
        }

        private void backtrack(int[] nums, List<Integer> track, boolean[] used) {
            if (track.size() == nums.length) {
                res.add(new ArrayList<>(track)); //拷贝
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                track.add(nums[i]);
                backtrack(nums, track, used);
                used[i] = false;
                track.remove(track.size() - 1); //移除最后一个,如果用LinkedList 则是 track.removeLast();
            }
        }
    }
}
