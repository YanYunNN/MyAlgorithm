package easy;

/**
 * @author xcai
 * @date 2025/02/12
 * @see <a href=''>Conf<a/>
 *
 *示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
public class Q459_repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public boolean repeatedSubstringPattern1(String s) {
        for (int i = 1; i < s.length(); i++) {
            String str = rotate(s.toCharArray(), i);
            if (s.equals(str)) return true;
        }
        return false;
    }

    public String rotate(char[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return String.valueOf(nums);
    }

    public void reverse(char[] nums, int begin, int end) {
        int i = begin, j = end;
        while (i < j) {
            char temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
