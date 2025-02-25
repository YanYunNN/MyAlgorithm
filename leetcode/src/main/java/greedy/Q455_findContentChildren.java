package greedy;

import java.util.Arrays;

/**
 * @author xcai
 * @date 2025/02/24
 * @see <a href=''>Conf<a/>
 *
 * @示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1 解释:你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。所以你应该输出 1。
 *
 * @示例 2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。你拥有的饼干数量和尺寸都足以让所有孩子满足。所以你应该输出 2.
 */
public class Q455_findContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int idx = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (idx >= 0 && s[idx] >= g[i]) idx--;
        }
        return s.length - 1 - idx;
    }
}
