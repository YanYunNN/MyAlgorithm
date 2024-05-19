package medium;

import base.TreeNode;

import java.util.*;

/**
 * @topic 二叉树的锯齿形层序遍历
 * @date 2024/05/11
 */
public class Q103_btree_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isOrderLeft = true;//标记下，是否从左到右

        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size(); //需要用临时变量保存，因为queue是动态的
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(new LinkedList<>(levelList)); //需要将deque转换为list
            isOrderLeft = !isOrderLeft; //变换顺序
        }
        return ans;
    }
}
