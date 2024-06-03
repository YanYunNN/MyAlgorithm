package zhard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @* 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * @* 输出：[3,3,5,5,6,7]
 * @* 解释：
 * @* 滑动窗口的位置                最大值
 * @* ---------------               -----
 * @* [1  3  -1] -3  5  3  6  7       3
 * @* 1 [3  -1  -3] 5  3  6  7       3
 * @* 1  3 [-1  -3  5] 3  6  7       5
 * @* 1  3  -1 [-3  5  3] 6  7       5
 * @* 1  3  -1  -3 [5  3  6] 7       6
 * @* 1  3  -1  -3  5 [3  6  7]      7
 * @author: xcai
 * @date: 2024/05/30
 * @see <a href='https://leetcode.cn/problems/sliding-window-maximum/solutions/1212012/acm-xuan-shou-tu-jie-leetcode-hua-dong-c-i3wj/'>Conf<a/>
 */
public class Q239_maxSlidingWindow {

    //大根堆
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        //存储二元组 (num,index)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];//堆顶放大的值，值相同的把坐标大的放堆顶
        });

        int[] ans = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            // 将当前元素添加到堆中
            pq.offer(new int[]{nums[i], i});
            // 确保堆顶元素在当前窗口范围内
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // 当窗口达到大小 k 时，记录当前窗口的最大值
            if (i >= k - 1) {
                ans[index++] = pq.peek()[0];
            }
        }
        return ans;
    }

    //单调递减队列,队尾比不过同龄人的删掉，队头超出时代区间的删掉
    public int[] maxSlidingWindow(int[] nums, int k) {
        ///用双端队列来存储数组的下标,存下标可以更方便的来确定元素是否需要移出滑动窗口
        Deque<Integer> queue = new LinkedList<>();
        if (nums == null || nums.length < k) return null;
        int[] res = new int[nums.length + 1 - k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //保证队列的单调递减，使队列的出口始终为最大值
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            //放了一个值，因此需要做判断，判断队列出口的值是否合法，如果值的下标不在窗口内则要将其移出
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            //当窗口=k的时候，放入res
            if (i + 1 >= k) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
