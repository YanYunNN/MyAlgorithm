package easy;

public class Q074_binarySearch {
    class solution1 {
        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int left = 0, right = nums.length - 1;
            return binarySearch(nums, target, left, right);
        }

        public int binarySearch(int[] nums, int target, int left, int right) {
            if (left > right) return -1;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) return binarySearch(nums, target, mid + 1, right);
            else return binarySearch(nums, target, left, mid - 1);
        }
    }

    class solution2 {
        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) right = mid - 1;
                else if (nums[mid] < target) left = mid + 1;
                else return mid;
            }
            return -1;
        }

    }
}
