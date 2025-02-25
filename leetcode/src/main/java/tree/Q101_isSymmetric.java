package tree;

import base.TreeNode;

public class Q101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null) return false;
        else if (right == null) return false;
        else if (left.val != right.val) return false;

        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}
