package com.yanyun.sword;

import java.util.*;

public class _04_reConstructBinaryTree {
    //递归
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                //左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }

        }
        return root;
    }


    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _04_reConstructBinaryTree binaryTree = new _04_reConstructBinaryTree();
        TreeNode treeNode = binaryTree.reConstructBinaryTree(preOrder, inOrder);
        System.out.println("层序：  " + binaryTree.levelOrder(treeNode).toString());
        System.out.println("先序：  " + binaryTree.preOrder(treeNode).toString());
        System.out.println("中序：  " + binaryTree.inOrder(treeNode).toString());
        System.out.println("后序：  " + binaryTree.postOrder(treeNode).toString());
    }

    /**
     * --------------------------------------------------INIT-----------------------------------------------------------
     */
    private static int[] preOrder = new int[]{1, 2, 3, 4, 5, 6, 7};
    private static int[] inOrder = new int[]{3, 2, 4, 1, 6, 5, 7};

    //Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //遍历
    List<Integer> levelOrderList = new ArrayList<>();
    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> inOrderList = new ArrayList<>();
    List<Integer> postOrderList = new ArrayList<>();

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

    public List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        preOrderList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return preOrderList;
    }

    public List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
        return inOrderList;
    }

    public List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        postOrder(root.left);
        postOrder(root.right);
        postOrderList.add(root.val);
        return postOrderList;
    }
}




