package medium;

/**
 * @author xcai
 * @date 2024/06/06
 * @tag 二分、z字抽象BST
 * @see <a href='https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/1065178/gong-shui-san-xie-yi-ti-shuang-jie-er-fe-y1ns/'>Conf<a/>
 */
public class Q240_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            //逐行二分
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (matrix[i][mid] <= target) l = mid;
                else r = mid - 1;
            }
            if (matrix[i][r] == target) return true;
        }
        return false;
    }

    /**
     * 二分
     */
    static class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int[] row : matrix) {
                int index = search(row, target);
                if (index >= 0) {
                    return true;
                }
            }
            return false;
        }

        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = nums[mid];
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    }

    static class Solution2 {
        /**
         * 矩阵以右上角作为根节点，抽象BST树
         * 从根（右上角）开始搜索，如果当前的节点不等于目标值，可以按照树的搜索顺序进行：
         * <p>
         * 当前节点「大于」目标值，搜索当前节点的「左子树」，也就是当前矩阵位置的「左方格子」，即 ccc--
         * 当前节点「小于」目标值，搜索当前节点的「右子树」，也就是当前矩阵位置的「下方格子」，即 rrr++
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int r = 0, c = n - 1;
            while (r < m && c >= 0) {
                if (matrix[r][c] < target) r++;     //右子树
                else if (matrix[r][c] > target) c--;//左子树
                else return true;
            }
            return false;
        }
    }
}
