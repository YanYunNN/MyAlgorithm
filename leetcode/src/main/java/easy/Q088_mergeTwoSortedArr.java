package easy;

public class Q088_mergeTwoSortedArr {

    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[i - 1] = nums1[m - 1]; //直接覆盖，替代swap，参考官方题解“逆向双指针解法”的公式
                i--;
                m--;
            } else {
                nums1[i - 1] = nums2[n - 1];
                i--;
                n--;
            }
        }
    }
}
