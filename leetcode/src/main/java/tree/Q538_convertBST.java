package tree;

import base.TreeNode;

public class Q538_convertBST {
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }

    private int convertBST(TreeNode root, int sum) {
        if (root == null) return sum;
        sum = convertBST(root.right, sum);
        sum += root.val;
        root.val = sum;
        sum = convertBST(root.left, sum);
        return sum;
    }

}
