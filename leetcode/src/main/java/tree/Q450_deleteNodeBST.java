package tree;

import base.TreeNode;

public class Q450_deleteNodeBST {
    public TreeNode deleteTheNode(TreeNode node) {
        if (node == null) return null;
        if (node.right == null) return node.left;
        // 右子树不为空，左子树可空可不空，删除根节点，BST应该是右子树上位
        TreeNode cur = node.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur.left = node.left;//也即把左子树在右子树找合适的位置挂上
        return node.right;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) return deleteTheNode(root);
        if (root.val < key) root.right = deleteNode(root.right, key);
        if (root.val > key) root.left = deleteNode(root.left, key);
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode pre = root, cur = root;
        while (cur != null) {
            if (cur.val == key) break;
            pre = cur;
            cur = cur.val < key ? root.right : root.left;
        }
        if (pre.left != null && pre.left.val == key) {
            pre.left = deleteTheNode(cur);
        } else if (pre.right != null && pre.right.val == key) {
            pre.right = deleteTheNode(cur);
        }
        return root;
    }
}
