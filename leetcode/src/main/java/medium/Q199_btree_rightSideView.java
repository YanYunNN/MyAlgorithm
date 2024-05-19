package medium;

import java.util.ArrayList;
import java.util.List;

import base.TreeNode;

public class Q199_btree_rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //先递归右子树，再递归左子树，当某个深度首次到达时，对应的节点就在右视图中
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        if (depth == res.size()) { //dfs 首次=深度时
            res.add(root.val);
        }
        dfs(root.right, depth + 1, res);// 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1, res);
    }
}
