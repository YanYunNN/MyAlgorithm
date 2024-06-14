package easy;

/**
 * @author xcai
 * @date 2024/06/14
 * @see <a href='https://leetcode.cn/problems/longest-common-prefix/solutions/288575/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/'>Conf<a/>
 */
public class Q014_longestCommonPrefix {

    /**
     * 思路0，纵向比较
     */
    class Solution0 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {//挨个对比，短路
                    if (i == strs[j].length() || c != strs[j].charAt(i)) {//任何一个字符串到头或者不=，则结束
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];//穿针引线结束，说明最长
        }
    }

    /**
     * 思路一，挨个比较，取公共前缀
     */
    class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            int count = strs.length;
            for (int i = 1; i < count; i++) {
                prefix = commonPrefix(prefix, strs[i]);
                if (prefix.isEmpty()) {
                    break;
                }
            }
            return prefix;
        }

        private String commonPrefix(String str1, String str2) {
            int len = Math.min(str1.length(), str2.length());
            int idx = 0;
            while (idx < len && str1.charAt(idx) == str2.charAt(idx)) idx++;
            return str1.substring(0, idx);
        }
    }

    /**
     * 思路一，分治，俩俩比较取公共前缀
     */
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            } else {
                return longestCommonPrefix(strs, 0, strs.length - 1);
            }
        }

        public String longestCommonPrefix(String[] strs, int start, int end) {
            if (start == end) {
                return strs[start];
            } else {
                int mid = (end - start) / 2 + start;
                String lcpLeft = longestCommonPrefix(strs, start, mid);
                String lcpRight = longestCommonPrefix(strs, mid + 1, end);
                return commonPrefix(lcpLeft, lcpRight);
            }
        }

        public String commonPrefix(String lcpLeft, String lcpRight) {
            int minLength = Math.min(lcpLeft.length(), lcpRight.length());
            for (int i = 0; i < minLength; i++) {
                if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                    return lcpLeft.substring(0, i);
                }
            }
            return lcpLeft.substring(0, minLength);
        }
    }

}
