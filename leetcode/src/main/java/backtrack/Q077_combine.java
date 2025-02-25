package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/20
 * @see <a href='https://programmercarl.com/0077.%E7%BB%84%E5%90%88.html#%E6%80%9D%E8%B7%AF'>Conf<a/>
 */
public class Q077_combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    public void backtrack(int n, int k, int start) {
        // 终止条件
        if (path.size() > k) return;
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝优化,i是可以开始找的位置，比如n=4，k=3，那么i最多从2开始，否则不够了
        // n叉树遍历，for循环横向遍历，递归纵向遍历，回溯不断调整结果集
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(n, k, i + 1);
            path.removeLast();
        }
    }
}
