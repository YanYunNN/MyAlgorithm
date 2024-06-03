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
public class Q145_tree_postorder {

    class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            postorder(root);
            return res;
        }

        private void postorder(TreeNode root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            res.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left); //先left，这样left后出,倒过来就是left-right-root
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
}
