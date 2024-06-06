package medium;

/**
 * @author xcai
 * @date 2024/06/06
 * @see <a href=''>Conf<a/>
 * *
 * *示例 1：
 * *输入：nums = [5,7,7,8,8,10], target = 8
 * *输出：[3,4]
 * <p>
 * *示例 2：
 * *输入：nums = [5,7,7,8,8,10], target = 6
 * *输出：[-1,-1]
 */
public class Q034_search_first_last {
    /**
     * 数组已经排序，因此整个数组是单调递增的，我们可以利用二分法来加速查找的过程
     * 两次二分查找，分开查找第一个和最后一个,时间复杂度 O(log n), 空间复杂度 O(1)
     * [1,2,3,3,3,3,4,5,9]
     * <p>
     * right=middle-1 就是向左缩小范围，找第一个等于的元素
     * left=middle+1  就是向右缩小范围找最后一个等于的元素
     */
    public int[] searchRange(int[] nums, int target) {
        int L = 0, R = nums.length - 1;
        int first = -1, last = -1;
        // 第一个等于target的位置
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == target) {
                first = mid;
                R = mid - 1;//找到中间3后，继续往左找；
            } else if (nums[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        // 最后一个等于target的位置(如果 start 存在，那么 end 必定存在)
        L = 0; R = nums.length - 1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] == target) {
                last = mid;
                L = mid + 1;//重点，找到中间3后，继续往右找；
            } else if (nums[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return new int[]{first, last};
    }
}
