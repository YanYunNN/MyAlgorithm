package medium;

import base.TreeNode;

public class Q105_tree_pre_in_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) return null;
        return build(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    /**
     * @param preorder 二叉树前序遍历结果
     * @param preLeft  二叉树前序遍历结果的左边界
     * @param preRight 二叉树前序遍历结果的右边界
     * @param inorder  二叉树后序遍历结果
     * @param inLeft   二叉树后序遍历结果的左边界
     * @param inRight  二叉树后序遍历结果的右边界
     * @return {@link TreeNode }
     * @Ref 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/8946/qian-xu-bian-li-python-dai-ma-java-dai-ma-by-liwei/
     */
    public TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        int pivot = preorder[preLeft]; //root
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = inLeft;
        while (inorder[pivotIndex] != pivot) {
            pivotIndex++;
        }

        //key:  (pivotIndex - inLeft) + preLeft : 左子树的len+偏移
        root.left = build(preorder, preLeft + 1, (pivotIndex - inLeft) + preLeft, inorder, inLeft, pivotIndex - 1);
        root.right = build(preorder, (pivotIndex - inLeft) + preLeft + 1, preRight, inorder, pivotIndex + 1, inRight);
        return root;
    }

}
