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

            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) { //如果有右节点，其也要进行中序遍历
                    cur = node.right;
                }
            }
            return res;
        }
    }
}
