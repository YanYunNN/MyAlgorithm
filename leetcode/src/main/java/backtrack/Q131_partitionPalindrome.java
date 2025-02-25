package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/20
 * @see <a href=''>Conf<a/>
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class Q131_partitionPalindrome {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return res;
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) { // 切割，只有当前是回文，才会递归切割下一个
                path.add(str);
                backtrack(s, i + 1);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome1(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }
}
