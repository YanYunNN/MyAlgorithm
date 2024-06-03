package easy;

import base.TreeNode;

public class Q110_tree_isBalanced {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int L = maxDepth(root.left);
            int R = maxDepth(root.right);
            return Math.abs(L - R) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            return depth(root) != -1;
        }

        /**
         * @param root 后序遍历
         * @return -1:非平衡 否则返回高度
         */
        private int depth(TreeNode root) {
            if (root == null) return 0;
            int left = depth(root.left);
            if (left == -1) return -1;  //剪枝
            int right = depth(root.right);
            if (right == -1) return -1; //剪枝

            return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
        }
    }

}
