package tree;

import base.TreeNode;

import java.util.Stack;

public class Q98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(root.left, lower, root.val) && validBST(root.right, root.val, upper);
    }

    // 迭代
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;
            root = pop.right;
        }
        return true;
    }


    public class s2 {
        private long prev = Long.MIN_VALUE;

        public boolean isValidBST2(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST2(root.left)) {
                return false;
            }
            if (root.val <= prev) { // 不满足二叉搜索树条件
                return false;
            }
            prev = root.val;
            return isValidBST2(root.right);
        }
    }
}
