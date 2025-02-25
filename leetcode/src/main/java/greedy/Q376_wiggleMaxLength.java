package greedy;

/**
 * @author xcai
 * @date 2025/02/24
 * @see <a href=''>Conf<a/>
 *
 * @示例 1：
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 *
 * @示例 2：
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 *
 * @示例 3：
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 */
public class Q376_wiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int sum = 1; //最少是1.因为上面条件之后就是2个树，如果是平坡2个数就也是1
        Boolean asc = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] > nums[i - 1]) { //上坡
                if (asc != null && asc) continue; //连续上坡
                asc = true;
            } else { //下坡
                if (asc != null && !asc) continue; //连续下坡
                asc = false;
            }
            sum++;
        }
        return sum;
    }

}
