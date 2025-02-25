package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/24
 * @see <a href=''>Conf<a/>
 *
 * @示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * @示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * @示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class Q093_restoreIpAddresses {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0); // [255,255,11,135]
        return res;
    }

    public void dfs(String s, int index) {
        if (index == s.length() && path.size() == 4) { //base case
            res.add(String.join(".", path));
            return;
        }
        for (int i = index; i < s.length() && i < index + 3; i++) {
            //剪枝,不够或者多了
            if (path.size() + (s.length() - index) < 4) {
                break;
            }
            String node = s.substring(index, i + 1); //左闭右开
            if (isValid(node)) {
                path.add(node);
                dfs(s, i + 1);
                path.removeLast();
            }
        }
    }

    public boolean isValid(String node) {
        int num = Integer.parseInt(node);
        if ("0".equals(node) || (node.charAt(0) != '0' && num >= 0 && num <= 255)) {
            return true;
        }
        return false;
    }

    // 每个整数位于 0 到 255 之间组成，且不能含有前导 0
    private Boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false; //前导0

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false; //非法
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }

}