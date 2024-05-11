package medium;

import base.TreeNode;

public class Q236_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
        if (root == null || root == p || root == q) {//终止条件，DFS，不用往下找了
            return root;
        }
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q); //左子树DFS
        TreeNode right = lowestCommonAncestor(root.right, p, q); //右子树DFS
        if (left == null && right == null) return null; //左右都没有pq的最近公共祖先，则没有
        if (left == null) return right; //左子树没有p也没有q，就返回右子树的结果
        if (right == null) return left; //右子树没有p也没有q就返回左子树的结果
        return root; //左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
    }

}
