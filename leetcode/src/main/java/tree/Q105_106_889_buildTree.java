package tree;

import base.TreeNode;

public class Q105_106_889_buildTree {
    public class pre_in {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
            if (preBegin > preEnd || inBegin > inEnd) {
                return null;
            }

            int rootVal = preorder[preBegin];
            int idx = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootVal) {
                    idx = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preBegin + 1, preBegin + idx - inBegin, inorder, inBegin, idx - 1);
            root.right = build(preorder, preBegin + idx - inBegin + 1, preEnd, inorder, idx + 1, inEnd);
            return root;
        }
    }

    public class in_post {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, postorder.length - 1, postorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
            if (inBegin > inEnd || postBegin > postEnd) {
                return null;
            }

            int rootVal = postorder[postEnd];
            int idx = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootVal) {
                    idx = i;
                    break;
                }
            }

            TreeNode root = new TreeNode(rootVal);
            root.left = build(inorder, inBegin, idx - 1, postorder, postBegin, postBegin + idx - inBegin - 1);
            root.right = build(inorder, idx + 1, inEnd, postorder, postBegin + idx - inBegin, postEnd - 1);
            return root;
        }
    }


    public class pre_post {
        public TreeNode buildTree(int[] preorder, int[] postorder) {
            return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preBegin, int preEnd, int[] postorder, int postBegin, int postEnd) {
            if (preBegin > preEnd || postBegin > postEnd) {
                return null;
            }

            // 前序遍历的第一个元素是当前子树的根节点
            int rootVal = preorder[preBegin];
            TreeNode root = new TreeNode(rootVal);

            // 如果前序遍历的起始索引等于结束索引，说明只有一个节点，直接返回
            if (preBegin == preEnd) {
                return root;
            }
            // 在后序遍历中找到左子树的根节点
            int leftRootVal = preorder[preBegin + 1];
            int idx = 0;
            for (int i = postBegin; i <= postEnd; i++) {
                if (postorder[i] == leftRootVal) {
                    idx = i;
                    break;
                }
            }

            // 计算左子树的节点数量
            int leftTreeSize = idx - postBegin + 1;
            root.left = build(preorder, preBegin + 1, preBegin + leftTreeSize, postorder, postBegin, idx);
            root.right = build(preorder, preBegin + leftTreeSize + 1, preEnd, postorder, idx + 1, postEnd - 1);
            return root;
        }
    }

}
