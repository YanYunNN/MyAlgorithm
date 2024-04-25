package medium;

public class Q033_searchRotateSortedArr {
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[r]) { //右边有序，左边局部有序
                if (nums[mid] < target && target <= nums[r]) { //找右边
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { //左边有序，右边局部有序
                if (nums[l] <= target && target < nums[mid]) { //找左边
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
