package com.yanyun;

import java.util.*;

public class _018_MirrorTree {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * <p>
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * <p>
     * 递归
     */
    public void Mirror(TreeNode root) {
        if (root==null) return;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    /**
     * 非递归
     */
    public void Mirror1(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr, temp;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            //拿出队列，先交换，再利用队列依次处理子节点
            for (int i = 0; i < len; i++) {
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if (curr.left != null) nodes.offer(curr.left);
                if (curr.right != null) nodes.offer(curr.right);
            }
        }
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _018_MirrorTree clazz = new _018_MirrorTree();
        clazz.Mirror(root);
        boolean equals = Arrays.asList(8, 10, 6, 11, 9, 7, 5).equals(root.levelOrder(root));
        System.out.println(equals);
    }

    /**
     * --------------------------------------------------INIT-----------------------------------------------------------
     */
    private static TreeNode root= null;

    {
        root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
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




