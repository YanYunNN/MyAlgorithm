package com.yanyun.leetcode;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/17/19:36
 * @description [算法]
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 * <p>
 * ====================================================================================================================
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class _ctm_lowestCommonAncestor {


    /**
     * ==================================Method 1 ==========================================================
     */
    private TreeNode ans = null;

    /**
     * fx表示 x 节点的子树中是否包含 p 节点或 q 节点
     * (flson && frson) ∣∣ ((x = p ∣∣ x = q) && (flson∣∣ frson))
     * 左边： 根左或根右都包含p/q , pq不等于根且在左右俩颗树上
     * 右边： pq有一个是根且在同一颗树上
     */
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    /**
     * ==================================Method 2 ==========================================================
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left == null) return right;
        else return left;
    }


    /**
     * ==============================================INIT============================================================
     */
    private static TreeNode root = null;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    {
        root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(-1);
        root.left.left.left.left = new TreeNode(5);
    }

}
