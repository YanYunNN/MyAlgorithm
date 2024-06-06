package medium;

public class Q048_rotate {
    //方案一：辅助空间
    //方案二：四次翻转
    //方案三：水平反转再对角线反转

    /**
     * PS：这个方法不是原地
     * * matrix[row][col]，在旋转后，它的新位置为 matrixnew[col][n−row−1]
     * * 链接：https://leetcode.cn/problems/rotate-image/solutions/526980/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
     * ⎩
     * temp                     =matrix[row][col]
     * matrix[row][col]         =matrix[n−col−1][row]
     * matrix[n−col−1][row]     =matrix[n−row−1][n−col−1]
     * matrix[n−row−1][n−col−1] =matrix[col][n−row−1]
     * matrix[col][n−row−1]     =temp
     */
    public void rotateInPlace(int[][] matrix) {
        int n = matrix.length; //n*n，以5*5为例，四次转回到原点，使用temp保存临时量，至于ij，i是行 需要转i/2次，j需要转n+1/2次来区分奇偶
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    /**
     * PS：这个方法不是原地
     * * matrix[row][col]，在旋转后，它的新位置为 matrixnew[col][n−row−1]
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length; //n*n
        int[][] matrix_new = new int[n][n];
        //借用辅助matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        //挪移回来
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

}
