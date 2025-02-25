package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Q94_144_145_traversal {

    public static class recursion {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorder(root, res);
            inorder(root, res);
            postorder(root, res);
            return res;
        }

        private void preorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }

        private void inorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }

        private void postorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }

    public static class iteration {
        // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
            return res;
        }

        // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    cur = cur.left;
                    stack.push(cur);
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res;
        }

        // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (root.left != null) stack.push(root.left);
                if (root.right != null) stack.push(root.right);
            }
            Collections.reverse(res);// 左-右-中
            return res;
        }
    }
}
