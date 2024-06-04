package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xcai
 * @date: 2024/06/04
 * @see <a href=''>Conf<a/>
 * 输入 candidates = [1,2,3], target = 3
 * 输出 [ [1,1,1],[1,2],[3] ]
 */
public class Q039_traverse_combinationSum {
    List<List<Integer>> res = new ArrayList<>();
    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();
    // 记录 track 中的路径和
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (trackSum > target) return;
        for (int i = start; i < candidates.length; i++) {
            trackSum += candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, i, target); //backtrack(candidates, start, target);改了就变成全排列了  //从 start + 1 开始就是代表不使用重复元素
            track.removeLast();
            trackSum += candidates[i];
        }
    }
}
