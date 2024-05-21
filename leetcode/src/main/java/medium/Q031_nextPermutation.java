package medium;

public class Q031_nextPermutation {
    public void nextPermutation(int[] nums) {
        //1-2-4-3 -> 1-3-4-2
        //1. 倒序遍历, 找到第一个数, 这个数比后面的数小; 2<4
        //2. 继续倒序遍历, 找到一个上面的数大的数 3
        //3. 对换  1[2]4[3]->1[3]4[2]
        //4. 将第一轮的i后面的数升序排列, 只需要对撞双指针交换即可(因为i后面的数时降序的)
        //   得到1324

        int len = nums.length;
        int i = len - 2; //i = len - 2 是为了防止下面nums[i + 1]越界!
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0) {
                if (nums[j] > nums[i]) break;
                j--;
            }
            swap(nums, i, j);
        }
        //4. 将 i后面的数升序排列, 只需要对撞双指针交换即可(因为i后面的数时降序的)
        reverse(nums, i + 1, len - 1);
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
