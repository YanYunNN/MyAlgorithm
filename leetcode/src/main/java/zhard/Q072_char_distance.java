package zhard;

/**
 * @author: xcai
 * @date: 2024/05/16
 * @see <a href='https://leetcode.cn/problems/edit-distance/solutions/189676/edit-distance-by-ikaruga'>Conf<a/>
 */
public class Q072_char_distance {
    /***
     * 讲一下我自己对状态转移方程的理解,麻烦大家看看我说得对不对有没有道理:
     * (一)、当word1[i]==word2[j]时,由于遍历到了i和j,说明word1的0~i-1和word2的0~j-1的匹配结果已经生成,由于当前两个字符相同,因此无需做任何操作,dp[i][j]=dp[i-1][j-1]
     * (二)、当word1[i]!=word2[j]时,可以进行的操作有3个:
     *       ①替换操作:可能word1的0~i-1位置与word2的0~j-1位置的字符都相同, 只是当前位置的字符不匹配,进行替换操作后两者变得相同,
     *            所以此时dp[i][j]=dp[i-1][j-1]+1(这个加1代表执行替换操作)
     *       ②删除操作:若此时word1的0~i-1位置与word2的0~j位置已经匹配了, 此时多出了word1的i位置字符,应把它删除掉,才能使此时word1的0~i(这个i是执行了删除操作后新的i)
     *          和word2的0~j位置匹配,因此此时dp[i][j]=dp[i-1][j]+1(这个加1代表执行删除操作)
     *       ③插入操作:若此时word1的0~i位置只是和word2的0~j-1位置匹配, 此时只需要在原来的i位置后面插入一个和word2的j位置相同的字符使得
     *          此时的word1的0~i(这个i是执行了插入操作后新的i)和word2的0~j匹配得上,
     *           所以此时dp[i][j]=dp[i][j-1]+1(这个加1代表执行插入操作)
     *       ④由于题目所要求的是要最少的操作数:所以当word1[i] != word2[j] 时,需要在这三个操作中选取一个最小的值赋格当前的dp[i][j]
     * (三)总结:状态方程为:
     * if(word1[i] == word2[j]):
     *       dp[i][j] = dp[i-1][j-1]
     * else:
     *        min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
     * **/

     /* "" r o s
        "" 0  1 2 3
        h  1
        o  2
        r  3
        s  4
        e  5      x
        * */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; //+1 是在字符前补‘’，比如 horse -> ros : ''horse -> ''ros,这样是为了给dp数组赋初值
        for (int j = 0; j <= n; j++) dp[0][j] = j; // 第一行
        for (int i = 0; i <= m; i++) dp[i][0] = i; // 第一列

        //行：自底向上推导
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //当俩个字符相等，则说明不用做增删换操作，也即=不进行这一步的前一步：比如ho->ro 等价h->r
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {//这里因为是用的word的真实坐标，而dp是补了“”开头
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // word1[i]!=word2[j],存在增删改，取最小值
                // dp[i][j]：目标
                // dp[i-1][j-1]+1 换
                // dp[i-1][j]+1   删
                // dp[i][j-1]+1   增
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
