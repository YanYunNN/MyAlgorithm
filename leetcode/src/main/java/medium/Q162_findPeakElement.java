package easy;

/**
 * @author xcai
 * @date 2024/06/13
 * @see <a href=''>Conf<a/>
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 */
public class Q162_findPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) { //存在多个峰值 寻其一，一直往一个较大的方向找就能找到峰值
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findPeakElement1(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
