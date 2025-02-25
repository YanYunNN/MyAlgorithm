package tree;

import base.TreeNode;

public class Q669_trimBST {
    public TreeNode trimBST1(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        // 先找到在区间的子树
        while (root != null && (root.val < low || root.val > high)) {
            root = root.val < low ? root.left : root.right;
        }

        //处理左子树，此时只需要关注low
        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) { //修剪
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        //处理右子树，只需要关注子树与high
        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) { //修剪
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}
