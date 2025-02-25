package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_btree_rightSideView {
    public List<Integer> rightSideView0(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return list;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) { //最右侧元素
                    list.add(node.val);
                }
            }
        }
        return list;
    }

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
