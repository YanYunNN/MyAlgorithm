package medium;

/**
 * @author xcai
 * @date 2024/06/012
 * @tag 二分、z字抽象BST
 * @see <a href='https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/1065178/gong-shui-san-xie-yi-ti-shuang-jie-er-fe-y1ns/'>Conf<a/>
 */
public class Q240_searchMatrixI_Q74 {
    /**
     * 一次二分，拉平行为一行
     */
    static class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int x = matrix[mid / n][mid % n];
                if (x < target) {
                    low = mid + 1;
                } else if (x > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }


    /**
     * 2次二分：第一次先找列定位到某一行，第二次找行中值
     */
    static class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowIndex = binarySearchFirstColumn(matrix, target);
            if (rowIndex < 0) {
                return false;
            }
            return binarySearchRow(matrix[rowIndex], target);
        }

        public int binarySearchFirstColumn(int[][] matrix, int target) {
            int low = -1, high = matrix.length - 1;
            while (low < high) {
                int mid = (high - low + 1) / 2 + low;
                if (matrix[mid][0] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        public boolean binarySearchRow(int[] row, int target) {
            int low = 0, high = row.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }

    }
}
