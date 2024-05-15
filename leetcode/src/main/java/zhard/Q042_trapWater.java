package zhard;

/**
 * @author: xcai
 * @date: 2024/05/15
 * @relat 11. 盛最多水的容器;
 * @see <a href='https://labuladong.online/algo/frequency-interview/trapping-rain-water'>Conf<a/>
 */
public class Q042_trapWater {
    //对于i，water[i]=min(max(l),max(r))-height[i]
    public int trapDP(int[] height) { //会超时
        int res = 0, n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        //base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];

        //双DP计算好左右的最大值，减少计算 n^2->n
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    public int trapBase(int[] height) { //会超时
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxL = 0, maxR = 0;
            for (int j = 0; j < height.length; j++) {
                maxL = j <= i ? Math.max(height[j], maxL) : maxL;
                maxR = j >= i ? Math.max(height[j], maxR) : maxR;
            }
            int water = Math.min(maxL, maxR) - height[i];
            System.out.println("i:" + i + " maxl:" + maxL + " maxR:" + maxR + " water" + water);
            res += Math.min(maxL, maxR) - height[i];
        }
        return res;
    }

    public int trapDoublePoints(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;//左右双指针,l_max 和 r_max 代表的是 height[0..left] 和 height[right..end] 的最高柱子高度
        int lMax = 0, rMax = 0;
        while (left < right) { //left=right时，没有接雨水的空格了，因此计算结束
            lMax = Math.max(height[left], lMax);
            rMax = Math.max(height[right], rMax);
            if (height[left] < height[right]) {
                res += lMax - height[left];  //计算左边，因此左边待计算空格++
                left++;
            } else {
                res += rMax - height[right]; //计算右边，因此右边待计算空格--
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Q042_trapWater().trapBase(height));
    }

}
