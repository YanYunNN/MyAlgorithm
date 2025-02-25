package tree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q100_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            // 取出队列中的两个节点进行比较
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) { // 如果两个节点都为空，继续比较下一对节点
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) { // 如果其中一个节点为空，或者节点值不相等，返回 false
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.left);
            queue.offer(leftNode.right);
            queue.offer(rightNode.right);
        }
        return true;
    }

}
