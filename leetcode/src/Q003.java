import java.util.HashMap;

/**
 * q003
 * @author xin_cai
 * @date 2023/06/05
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Q003 {


    /**
     * 最长长度substring1
     * @param s 年代
     * @return int
     * 测试用例:"abcabcbb"
     * 测试结果:3
     * 期望结果:3
     * stdout:
     * {a=0, b=1, c=2}:a:1
     * {a=3, b=1, c=2}:b:2
     * {a=3, b=4, c=2}:c:3
     * {a=3, b=4, c=5}:b:5
     * {a=3, b=6, c=5}:b:7
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> windows = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (windows.containsKey(c)) {
                left = Math.max(left, windows.get(c) + 1);
                System.out.println(windows + ":" + c + ":" + left);
            }
            windows.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] map = new int[128];
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map[c]++;
            right++;
            while (map[c] > 1) {
                char d = s.charAt(left);
                map[d]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;

    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> windows = new HashMap<Character, Integer>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            while (windows.getOrDefault(c, 0) > 1) {
                char rmv = s.charAt(left);
                windows.put(rmv, windows.get(rmv) - 1);
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
