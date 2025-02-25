package tree;

import base.TreeNode;

public class Q700_searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST(root.right, val);
    }


    // 递归，利用二叉搜索树特点，优化
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST1(root.left, val);
        } else {
            return searchBST1(root.right, val);
        }
    }

    // 迭代，利用二叉搜索树特点，优化，可以不需要栈
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
}
