package tree;

import base.TreeNode;

import java.util.Arrays;

public class Q654_constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int rootIdx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                rootIdx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, rootIdx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, rootIdx + 1, nums.length));
        return root;
    }
}
