package medium;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q226_invertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }
}
