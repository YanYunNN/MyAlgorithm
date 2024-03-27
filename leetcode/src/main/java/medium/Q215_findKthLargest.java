package medium;

import java.util.PriorityQueue;
import java.util.Random;

public class Q215_findKthLargest {

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                queue.offer(nums[i]);
            }
            for (int j = k; j < nums.length; j++) {
                int n = queue.peek();
                if (nums[j] > n) {
                    queue.offer(nums[j]);
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution2 {

        int quickSelect(int[] nums, int l, int r, int k) {
            if (l == r)
                return nums[k];
            int pivot = nums[l], i = l - 1, j = r + 1; // 这里注意需要左右移1
            while (i < j) {
                while (nums[++i] < pivot) ;
                while (nums[--j] > pivot) ;
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            // 只需要递归一半区间
            if (k <= j)
                return quickSelect(nums, l, j, k);
            else
                return quickSelect(nums, j + 1, r, k);
        }

        public int findKthLargest(int[] _nums, int k) {
            int n = _nums.length;
            return quickSelect(_nums, 0, n - 1, n - k);
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution3 {

        public int findKthLargest(int[] nums, int k) {
            int left = 0, right = nums.length - 1;
            int target = nums.length - k;
            while (left <= right) {
                int index = partition(nums, left, right);
                if (index < target) {
                    left = index + 1;
                } else if (index > target) {
                    right = index - 1;
                } else return nums[index];
            }
            return Integer.MIN_VALUE;
        }

        private int partition(int[] nums, int left, int right) {
            int pos = left + new Random().nextInt(right - left + 1);
            swap(nums, pos, right);

            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (nums[j] <= nums[right]) {
                    swap(nums, ++i, j);
                }
            }
            swap(nums, i + 1, right);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution4 {
        public int findKthLargest(int[] nums, int k) {
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = nums[i];
            }
            buildHeap(arr, k - 1);
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > arr[0]) {
                    arr[0] = nums[i];
                    heapify(arr, k - 1, 0);
                }
            }
            return arr[0];
        }

        private void buildHeap(int[] nums, int n) {
            for (int i = n / 2; i >= 0; i--) {
                heapify(nums, n, i);
            }
        }

        private void heapify(int[] nums, int n, int i) {
            while (true) {
                int minPos = i, left = 2 * i + 1, right = left + 1;
                if (left <= n && nums[minPos] > nums[left]) minPos = left;
                if (right <= n && nums[minPos] > nums[right]) minPos = right;
                if (minPos == i) break;
                swap(nums, i, minPos);
                i = minPos;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
