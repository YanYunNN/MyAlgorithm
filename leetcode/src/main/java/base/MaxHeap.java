package base;

public class MaxHeap {
    public int heapify(int[] nums) {
        int length = nums.length;
        //循环建立初始堆，调用 sift 算法 ⌊n / 2⌋ 次
        for (int i = (length - 1) / 2; i >= 0; i--) {
            sift(nums, i, length - 1);
        }
        return -1;
    }

    //对 nums[low...high] 进行筛选，使得以 nums[low] 为根节点的左子树和右子树均为大根堆
    public void sift(int[] nums, int low, int high) {
        // nums[j] 是 nums[i] 的左孩子
        int i = low;
        int j = (i == 0) ? 1 : 2 * i;
        int tmp = nums[i];
        while (j <= high) {
            //如果右孩子更大，则将 j 指向右孩子
            if (j < high && nums[j] < nums[j + 1]) {
                j++;
            }
            //根节点小于最大孩子节点
            if (tmp < nums[j]) {
                nums[i] = nums[j];
                nums[j] = tmp;
                i = j;
                j = 2 * i;
            } else {
                //如果跟节点大于等于最大孩子关键字，筛选结束
                break;
            }
        }
    }
}
