package easy;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 是否是对称树
 */
public class Q113_tree_hasPathSumII {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        if (root.left == null && root.right == null && targetSum == root.val) {
            List<Integer> tmp = new ArrayList<>(path);
            tmp.add(root.val);
            res.add(tmp);
            return;
        }
        path.add(root.val);
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.removeLast();
    }
}
