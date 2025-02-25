package tree;

import base.TreeNode;

public class Q235_236_lowestCommonAncestor {
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorBST(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestorBST(root.right, p, q);
        return root;//root.val=q.val=p.val;
    }

    public TreeNode lowestCommonAncestorBST1(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件：如果当前节点为空，或者当前节点是 p 或 q，直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左子树和右子树各自找到了 p 或 q，说明当前节点就是最近公共祖先
        if (left != null && right != null) return root;

        // 如果只有左子树或右子树找到了 p 或 q，返回非空的结果（向上传导），递归出口在下面
        return left != null ? left : right;
    }
}
