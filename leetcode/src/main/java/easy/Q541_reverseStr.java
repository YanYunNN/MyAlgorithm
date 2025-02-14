package easy;

/**
 * @author xcai
 * @date 2025/02/12
 * @see <a href=''>Conf<a/>
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class Q541_reverseStr {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int l = i, r = Math.min(i + k - 1, arr.length - 1);
            while (l < r) {
                char tmp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = tmp;
            }
        }
        return new String(arr);
    }
}
