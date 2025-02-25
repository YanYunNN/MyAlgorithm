package tree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q404_sumOfLeftLeaves {
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;

        int val = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            val = root.left.val;
        }
        return val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                }
                if (node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }
}
