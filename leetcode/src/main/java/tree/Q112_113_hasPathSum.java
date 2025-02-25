package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q112_113_hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

    /**
     *给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return res;
    }

    private void traverse(TreeNode node, int targetSum) {
        if (node == null) return;
        if (node.left == null && node.right == null && targetSum == node.val) {
            List<Integer> tmp = new ArrayList<>(track);
            tmp.add(node.val);
            res.add(tmp);
        }
        track.add(node.val); // do
        traverse(node.left, targetSum - node.val);
        traverse(node.right, targetSum - node.val);
        track.removeLast(); // undo
    }
}
