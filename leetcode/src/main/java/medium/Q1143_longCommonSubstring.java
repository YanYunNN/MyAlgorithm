package medium;

/**
 * @see zhard/Q072_char_distance.java 编辑距离lcs
 */
public class Q1143_longCommonSubstring {
    public int longestCommonSubsequence(String text1, String text2) {
        //lcs dp数组，str前需要包括‘’空字符开头
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        //base case 也可以省略 因为默认为0
        for (int i = 0; i < m; i++) dp[i][0] = 0; //第一列
        for (int j = 0; j < n; j++) dp[0][j] = 0; //第一行

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                //已知
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { //涉及数值比较的，记得-1，因为dp数组包含了空字符开头
                    dp[i][j] = dp[i - 1][j - 1] + 1; //lcs常见 左上角相等；
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
