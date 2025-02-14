package easy;

/**
 * @author xcai
 * @date 2025/02/12
 * @see <a href='https://kamacoder.com/problempage.php?pid=1065'>https://kamacoder.com/problempage.php?pid=1065<a/>
 *
 * 样例输入：
 * 2
 * abcdefg
 * 样例输出：
 * fgabcde
 */
public class QK55_Krotate {
    public String reverseStr(String s, int k) {
        char[] nums = s.toCharArray();
        k = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
        return new String(nums);
    }

    public void rotate(char[] nums, int begin, int end) {
        while (begin < end) {
            char tmp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
