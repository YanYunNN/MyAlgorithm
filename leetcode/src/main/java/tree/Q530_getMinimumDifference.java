package tree;

import base.TreeNode;

public class Q530_getMinimumDifference {
    int result = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root; //左->中
        traversal(root.right);
    }
}
