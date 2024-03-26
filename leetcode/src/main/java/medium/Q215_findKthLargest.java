package medium;

import java.util.PriorityQueue;

public class Q215_findKthLargest {

    //leetcode submit region begin(Prohibit modification and deletion)
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
    //leetcode submit region end(Prohibit modification and deletion)

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution2 {
        int quickSelect(int[] nums, int l, int r, int k) {
            if (l == r) return nums[k];
            int pivot = nums[l], i = l - 1, j = r + 1;
            while (i < j) {
                while (nums[++i] < pivot) ;
                while (nums[--j] > pivot) ;
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            //只需要递归一半区间
            if (k <= j) return quickSelect(nums, l, j, k);
            else return quickSelect(nums, j + 1, r, k);
        }

        public int findKthLargest(int[] _nums, int k) {
            int n = _nums.length;
            return quickSelect(_nums, 0, n - 1, n - k);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
