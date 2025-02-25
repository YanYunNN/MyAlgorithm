package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", result);
        }
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", result);
        }
        // 这里不需要显式回溯操作，因为字符串是不可变的
        // 每次递归调用都会创建新的字符串副本
    }
}
