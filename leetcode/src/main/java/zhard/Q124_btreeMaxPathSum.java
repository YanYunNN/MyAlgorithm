package zhard;

import base.TreeNode;

public class Q124_btreeMaxPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftMax = dfs(root.left); //左子树最大路径和
        int rightMax = dfs(root.right); //右
        // 子树最大路径和
        res = Math.max(res, leftMax + rightMax + root.val); //更新全局最大值

        int max = Math.max(root.val + leftMax, root.val + rightMax);
        return max < 0 ? 0 : max; //<0则舍弃
    }
}
