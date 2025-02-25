package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/20
 * @see <a href='https://programmercarl.com/0077.%E7%BB%84%E5%90%88.html#%E6%80%9D%E8%B7%AF'>Conf<a/>
 * @desc 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class Q216_combinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 0, 1);
        return res;
    }

    public void backtrack(int k, int n, int sum, int start) {
        if (sum > n || path.size() > k) return; //剪枝
        if (path.size() == k) {
            if (sum == n) res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) { //剪枝
            sum += i;
            path.add(i);
            backtrack(k, n, sum, i + 1);
            sum -= i;
            path.removeLast();
        }
    }
}
