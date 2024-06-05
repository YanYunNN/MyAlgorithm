package medium;

import base.TreeNode;

/**
 * 有效二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 */
public class Q098_tree_isValidBST {
    class Solution {
        boolean isBST = true; //外部变量
        TreeNode pre = null;

        public boolean isValidBST(TreeNode root) {
            inOrder(root);
            return isBST;
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            /* 中序遍历位置 */
            if (pre != null && pre.val >= root.val) { //不是递增有序
                isBST = false;
                return;
            }
            pre = root; //当前节点中序遍历结束，变成前一个遍历的节点
            inOrder(root.right);
        }
        /*long pre = Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            if (!isValidBST(root.left)) return false;
            // 中序遍历
            if (root.val <= pre) return false;
            pre = root.val;

            return isValidBST(root.right);
        }*/
    }

    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode node, long lower, long upper) {
            if (node == null) return true;
            if (node.val <= lower || node.val >= upper) return false;
            return isValidBST(node.left, lower, node.val) &&
                    isValidBST(node.right, node.val, upper);
        }
    /*
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        if (root.left != null && root.left.val > root.val) return false;
        if (root.right != null && root.right.val < root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }*/
    }
}
