package medium;

/**
 * @author xin_cai
 * @date 2024/05/13
 * @see <a href='https://leetcode.cn/problems/spiral-matrix/solutions/2362055/54-luo-xuan-ju-zhen-mo-ni-qing-xi-tu-jie-juvi'>Conf<a/>
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 */
public class Q059_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1;
        int curNum = 1;

        while (curNum <= n * n) {
            for (int i = l; i <= r; i++) matrix[t][i] = curNum++;
            t++;
            for (int i = t; i <= b; i++) matrix[i][r] = curNum++;
            r--;
            for (int i = r; i >= l; i--) matrix[b][i] = curNum++;
            b--;
            for (int i = b; i >= t; i--) matrix[i][l] = curNum++;
            l++;
        }
        return matrix;
    }
}
