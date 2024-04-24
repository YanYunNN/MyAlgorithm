package medium;

public class Q005_longestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] charArray = s.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            int l = i - 1, r = i + 1;
            while (l >= 0 && charArray[l] == charArray[i]) {
                l--;
                len++;
            }
            while (r < s.length() && charArray[r] == charArray[i]) {
                r++;
                len++;
            }
            while (l >= 0 && r < s.length() && charArray[l] == charArray[r]) {
                l--;
                r++;
                len += 2;
            }
            if (len > max) {
                max = len;
                start = l;
            }
        }
        return s.substring(start + 1, start + max + 1);//由于终止态时候，指针指向开区间，因此起点需要-1
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        //dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1],需要先从后向前计算
        /*0r-----*/
        /*l-\----*/
        /*---\T--*/
        /*----\TF*/
        /*-----\T*/
        //递推，取对角线右上区间，自底向上，自左向右（r>l）

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                dp[l][r] = s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1]); //r-l<2 需要考虑回文=1或2的情况
                if (dp[l][r] && r - l + 1 > res.length()) {
                    res = s.substring(l, r + 1);//左闭右开区间
                }
            }
        }
        return res;
    }
}
