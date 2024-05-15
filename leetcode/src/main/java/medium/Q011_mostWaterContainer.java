package medium;

/**
 * @author: xcai
 * @date: 2024/05/15
 * @relat 11. 盛最多水的容器;
 * @see <a href='https://labuladong.online/algo/frequency-interview/trapping-rain-water'>Conf<a/>
 */
public class Q011_mostWaterContainer {
    //max=min(lmax,rMax)*(r_max-l_max),双指针俩端收缩求极值
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1; //双指针
        while (left < right) {
            int area = Math.min(height[right], height[left]) * (right - left);
            res = Math.max(area, res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
