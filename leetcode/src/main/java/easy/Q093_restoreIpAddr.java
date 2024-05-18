package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * backtrack
 * @see <a href='https://labuladong.online/algo/essential-technique/backtrack-framework/'>Link<a/>
 * @see <a href='https://leetcode.cn/problems/restore-ip-addresses/solutions/100433/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by'>Link<a/>
 */
public class Q093_restoreIpAddr {
    public class Solution1 {
        List<String> res = new ArrayList<>();

        // 25525511135
        public List<String> restoreIpAddresses(String s) {
            List<String> path = new ArrayList<>(); // [255,255,11,135]
            backtrack(s, 0, path);
            return res;
        }

        private void backtrack(String s, int index, List<String> path) {
            if (index == s.length() && path.size() == 4) { //base case
                res.add(String.join(".", path));
                return;
            }
            for (int i = index; i < s.length() && i < index + 3; i++) { //单个ip段最多3个数
                //[101023] 画图理解剪枝
                //剪枝条件1：后面元素不够用了，如：[10,102,3]
                //剪枝条件2：后面元素太多了，如：[1,0,1,0,...]
                if (path.size() + (s.length() - index) < 4 || path.size() == 4 && index < s.length()) {
                    break;
                }
                String node = s.substring(index, i + 1);
                if (isValid(node)) {
                    path.add(node);
                    backtrack(s, i + 1, path);
                    path.remove(path.size() - 1);
                }

            }
        }

        //判断某个字符串是否是合法子段 首字母不为0且数字在0-255之间，或者字符串为"0"
        public boolean isValid(String node) {
            int num = Integer.parseInt(node);
            if ("0".equals(node) || (node.charAt(0) != '0' && num >= 0 && num <= 255)) {
                return true;
            }
            return false;
        }
    }
}
