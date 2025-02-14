package easy;

/**
 * @author xcai
 * @date 2025/02/12
 * @see <a href=''>Conf<a/>
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class Q028_strStr {
    public int strStr1(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        char[] arr1 = haystack.toCharArray(), arr2 = needle.toCharArray();
        //挨个检查
        for (int i = 0; i < n - m + 1; i++) {
            int a = i, b = 0;
            //匹配
            while (b < m && arr1[a] == arr2[b]) {
                a++;
                b++;
            }
            if (b == m) return i;
        }
        return -1;
    }
}
