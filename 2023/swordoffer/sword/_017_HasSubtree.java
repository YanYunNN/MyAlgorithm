package com.yanyun.sword;

import java.util.*;

public class _017_HasSubtree {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * <p>
     * {8,8,#,9,#,2,#,5},{8,9,#,2}
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * <p>
     * 递归
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return dfs(root1, root2) || dfs(root1.left, root2) || dfs(root1.right, root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        return root1.val == root2.val && dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _017_HasSubtree clazz = new _017_HasSubtree();
        System.out.println(Arrays.toString(root1.levelOrder(root1).toArray()));
        System.out.println(Arrays.toString(root2.levelOrder(root2).toArray()));
        boolean bool = clazz.HasSubtree(root1, root2);
        System.out.println(bool);
    }

    /**
     * --------------------------------------------------INIT-----------------------------------------------------------
     */
    private static TreeNode root1 = null;
    private static TreeNode root2 = null;

    {
        root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(-1);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(-1);
        root1.left.left.left = new TreeNode(2);
        root1.left.left.right = new TreeNode(-1);
        root1.left.left.left.left = new TreeNode(5);
    }

    {
        root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(-1);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(-1);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        List<Integer> levelOrderList = new ArrayList<>();

        public List<Integer> levelOrder(TreeNode root) {
            if (root == null) {
                return levelOrderList;
            }
            //借助队列
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                //出队入列表
                TreeNode temp = queue.poll();
                levelOrderList.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            return levelOrderList;
        }
    }
}




