package tree;

import base.TreeNode;

public class Q108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    public TreeNode traversal(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, begin, mid - 1);
        root.right = traversal(nums, mid + 1, end);
        return root;
    }
}
