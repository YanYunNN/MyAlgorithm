package medium;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xcai
 * @date 2024/06/19
 * @see <a href='https://leetcode.cn/problems/house-robber-ii/solutions/28258/213-da-jia-jie-she-iidong-tai-gui-hua-jie-gou-hua-/'>Conf<a/>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱      哪个组合钱多，就当做当前节点能偷的最大钱数
 */
public class Q198_dp_robIII_337 {
    class Solution1 {
        //重复子问题
        Map<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (memo.containsKey(root)) return memo.get(root);

            int money = root.val;
            if (root.left != null) {
                money += (rob(root.left.left) + rob(root.left.right));
            }

            if (root.right != null) {
                money += (rob(root.right.left) + rob(root.right.right));
            }

            int result = Math.max(money, rob(root.left) + rob(root.right));
            memo.put(root, result);
            return result;
        }
    }

    class Solution2 {
        public int rob(TreeNode root) {
            int[] result = robInner(root);
            return Math.max(result[0], result[1]);
        }

        public int[] robInner(TreeNode root) {
            int[] res = new int[2];
            if (root == null) return res;

            int[] left = robInner(root.left);
            int[] right = robInner(root.right);

            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  //当前节点不偷= 左孩子能偷到的钱 + 右孩子能偷到的钱
            res[1] = left[0] + right[0] + root.val; //当前节点偷=左节点不偷+右节点不偷+root偷
            return res;
        }

    }
}
