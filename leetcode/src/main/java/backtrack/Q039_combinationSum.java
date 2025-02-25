package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q039_combinationSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return; //剪枝
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i); // 关键点:不用i+1了，表示可以重复读取当前的数
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
