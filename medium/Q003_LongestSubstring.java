package medium;

import java.util.HashMap;
import java.util.Map;

public class Q003_LongestSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int res = 0;
            while (right < s.length()) {
                //先扩张
                char c = s.charAt(right);
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);
                //c右移，再收缩
                while (window.get(c) > 1) {
                    char d = s.charAt(left);//临时变量，存放个数2的坐标好-1
                    left++;
                    window.put(d, window.get(d) - 1);
                }
                res = Math.max(res, right - left);//因为left右移之前 已经有俩个了，所以需要以右移后的作为有效的left
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                map.put(d, map.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
