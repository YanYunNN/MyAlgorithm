package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q235_bst_lowestCommonAncestor {

    // 二叉搜索树，左节点<root<右节点，因此，存在三种情况
    // 1. pq都比root大就在右子树
    // 2. pq都比root小就在左子树
    // 3. 否则说明pq=root或者pq分散在root左右，直接返回，也就是递归出口
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break; //迭代出口
            }
        }
        return root;
    }

    // 思路二，dfs找出相同路径
    // 6->2->4->5
    // 6->2->0
    // 那么0，5的最近公共祖先就是2
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break; //不同则返回上一次公共节点也即最近祖先
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            node = node.val > target.val ? node.left : node.right;
        }
        path.add(node);// 最后加上target自身
        return path;
    }
}
