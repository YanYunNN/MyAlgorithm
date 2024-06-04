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
      /**
     * backtrack(candidates, i, target)：在当前层级中，可以重复使用 candidates 中的元素。
     * backtrack(candidates, i+1, target)：在当前层级中，不可以重复使用 candidates 中的元素，需要跳过已经使用过的元素。
     * backtrack(candidates, start, target)：在整个递归树中，需要重复使用 candidates 中的元素，因此回到上一层时，需要从 start 开始继续循环。
     *
     * 具体来说：
     * 在第一种调用方式中，i 代表当前层级循环的起点，可以重复使用 candidates 中的元素，因此从 i 开始循环。
     * 在第二种调用方式中，i+1 代表当前层级循环的起点，不能重复使用 candidates 中的元素，因此从 i+1 开始循环。
     * 在第三种调用方式中，start 代表整个递归树中循环的起点，需要重复使用 candidates 中的元素，因此从 start 开始循环。
     * */
}
