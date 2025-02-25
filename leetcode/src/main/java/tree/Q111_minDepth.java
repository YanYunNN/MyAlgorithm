package tree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Q111_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) return rightDepth + 1; //叶子节点到根
        if (root.right == null) return leftDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public int minDepth1(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth; //叶子节点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }
}