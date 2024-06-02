package easy;

import base.TreeNode;

/**
 * 是否是对称树
 */
public class Q101_tree_isSymmetric {
    //双指针
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val &&
                helper(left.left, right.right) &&
                helper(left.right, right.left);
    }
}
