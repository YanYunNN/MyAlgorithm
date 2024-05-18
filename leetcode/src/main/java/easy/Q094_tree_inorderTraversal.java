package easy;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q094_tree_inorderTraversal {
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    /**
     * 单调栈
     */
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return null;
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root.left != null) {  //左边不断入栈
                    stack.push(root.left);
                    root = root.left;
                } else {
                    TreeNode tmp = stack.pop();
                    res.add(tmp.val);
                    stack.push(tmp.right);
                }
            }
            return res;
        }
    }
}
