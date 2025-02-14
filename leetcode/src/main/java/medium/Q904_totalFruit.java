package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xcai
 * @date 2025/02/07
 * @see <a href=''>Conf<a/>
 *
 * 示例1：
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部3棵树，因为类型为1和2，各装一个篮子。
 *
 * 示例2：
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以选择[1,2,2]，长度为3。
 */
public class Q904_totalFruit {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>(); // 使用哈希表记录当前窗口内的水果类型及其最后出现的索引
        int maxLen = 0; // 记录最大水果数量
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            int fruit1 = fruits[right];
            basket.put(fruit1, basket.getOrDefault(fruit1, 0) + 1);

            // 如果窗口内的水果类型超过两种，调整左边界
            while (basket.size() > 2) {
                int fruit2 = fruits[left];
                basket.put(fruit2, basket.getOrDefault(fruit2, 0) - 1);
                if (basket.get(fruit2) == 0) {
                    basket.remove(fruit2);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
