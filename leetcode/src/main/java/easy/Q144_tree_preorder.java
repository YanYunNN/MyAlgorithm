package easy;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: xcai
 * @date: 2024/06/03
 * @see <a href='https://leetcode.cn/problems/binary-tree-preorder-traversal/solutions/87526/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2'>Conf<a/>
 */
public class Q144_tree_preorder {

    class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            preorder(root);
            return res;
        }

        private void preorder(TreeNode root) {
            if (root == null) return;
            res.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right); //先right，这样right后出
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
