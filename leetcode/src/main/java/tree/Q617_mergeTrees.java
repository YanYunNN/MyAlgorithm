package tree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q617_mergeTrees {
    public TreeNode mergeTrees(TreeNode p, TreeNode q) {
        if (p == null) return q;
        if (q == null) return p;

        p.val += q.val;
        p.left = mergeTrees(p.left, q.left);
        p.right = mergeTrees(p.right, q.right);

        return p;
    }

    public TreeNode mergeTrees1(TreeNode p, TreeNode q) {
        if (p == null) return q;
        if (q == null) return p;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            // 取出队列中的两个节点进行比较
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            node1.val += node2.val;

            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            } else if (node1.left == null) {
                node1.left = node2.left;
            }

            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            } else if (node1.right == null) {
                node1.right = node2.right;
            }
        }
        return p;
    }

}
