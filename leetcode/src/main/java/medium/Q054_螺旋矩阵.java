package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xin_cai
 * @date 2024/05/13
 * @see <a href='https://leetcode.cn/problems/spiral-matrix/solutions/2362055/54-luo-xuan-ju-zhen-mo-ni-qing-xi-tu-jie-juvi'>Conf<a/>
 */
public class Q054_螺旋矩阵 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return res;
            }
            int m = matrix.length, n = matrix[0].length;
            int l = 0, r = n - 1, t = 0, b = m - 1;
            while (true) {
                for (int i = l; i <= r; i++) res.add(matrix[t][i]); // left to right
                if (++t > b) break; //上界收缩，看看 t+1 是否越下界
                for (int i = t; i <= b; i++) res.add(matrix[i][r]); // top to bottom
                if (--r < l) break; //右界收缩，看看 r-1 是否越左界
                for (int i = r; i >= l; i--) res.add(matrix[b][i]); // right to left
                if (--b < t) break; //下界收缩，看看 b-1 是否越上界
                for (int i = b; i >= t; i--) res.add(matrix[i][l]); // bottom to top
                if (++l > r) break; //左界收缩，看看 l+1 是否越右界
            }
            return res;
        }

        public List<Integer> spiralOrder1(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return res;
            }
            int m = matrix.length, n = matrix[0].length;
            int left = 0, right = n - 1, top = 0, bottom = m - 1;
            while (left <= right && top <= bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                for (int i = top + 1; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                if (left < right && top < bottom) {
                    for (int i = right - 1; i >= left; i--) {
                        res.add(matrix[bottom][i]);
                    }
                    for (int i = bottom - 1; i > top; i--) {
                        res.add(matrix[i][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = n - 1, t = 0, b = m - 1;
        while (true) {
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);
            if (++t > b) break;
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; i--) res.add(matrix[b][i]);
            if (--b < t) break;
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
}
