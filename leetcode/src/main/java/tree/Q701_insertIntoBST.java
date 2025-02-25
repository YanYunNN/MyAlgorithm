package tree;

import base.TreeNode;

public class Q701_insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回
        if (root == null) return new TreeNode(val);

        if (root.val <= val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode next = root;
        TreeNode pre = root;

        while (next != null) { //直到找到正确的位置
            pre = next;
            if (next.val <= val) {
                next = next.right;
            } else {
                next = next.left;
            }
        }
        //此时next指针为null,pre指针为对应子树的中间节点，进行比较插入
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
        return root;
    }
}
