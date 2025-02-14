package easy;

import java.util.HashSet;

/**
 * @author xcai
 * @date 2025/02/11
 * @see <a href=''>Conf<a/>
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 */
public class Q202_isHappyNum {
    public boolean isHappy(int n) {
        HashSet<Integer> sets = new HashSet<>();
        int res = 0;
        while (res != 1 && !sets.contains(res)) {
            sets.add(res);
            res = getNextNum(res);
        }
        return true;
    }

    public int getNextNum(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}
