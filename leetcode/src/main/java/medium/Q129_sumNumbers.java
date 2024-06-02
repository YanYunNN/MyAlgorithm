package medium;

import base.TreeNode;

public class Q129_sumNumbers {
    /**
     * 变体：
     * 输入：root = [1,2,3]
     * 输出：25 解释：
     * 从根到叶子节点路径 1->2 代表数字 12
     * 从根到叶子节点路径 1->3 代表数字 13
     * 因此，数字总和 = 12 + 13 = 25
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int i) {
        if (root == null) return 0;
        int tmp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return tmp;
        }
        return dfs(root.left, tmp) + dfs(root.right, tmp);
    }

    public int sumNumbers0(TreeNode root) {
        if (root == null) return 0;
        int leftNum = root.left != null ? sumNumbers0(root.left) : 0;
        int rightNum = root.right != null ? sumNumbers0(root.right) : 0;
        return root.val + leftNum + rightNum;
    }
}
