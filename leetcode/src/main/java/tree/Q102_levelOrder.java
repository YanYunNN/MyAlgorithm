package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_levelOrder {

    /**
     * 迭代
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) { //for(int i=queue.size();i>0,i--)
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(subList);
        }
        return list;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.addFirst(subList); //这样即实现倒序

        }
        return list;
    }


    /**
     * 递归
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(root, 0, list);
        return list;
    }

    public void bfs(TreeNode node, int depth, List<List<Integer>> list) {
        if (node == null) return;
        depth++;

        if (list.size() < depth) {
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(node.val);

        bfs(node.left, depth, list);
        bfs(node.right, depth, list);
    }

}
