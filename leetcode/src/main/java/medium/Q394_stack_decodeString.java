package medium;

import java.util.Stack;

/**
 * @author: xcai
 * @date: 2024/06/04
 * @see <a href='https://leetcode.cn/problems/decode-string/solutions/19447/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd'>Conf<a/>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 */
public class Q394_stack_decodeString {
    public String decodeString(String s) {
        int k = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> kStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[') { //碰到括号，记录K和当前res，归零。
                kStack.push(k);
                resStack.push(res);
                k = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int _k = kStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < _k; i++) {
                    tmp.append(res);
                }
                res = resStack.pop().append(tmp); //与括号外合并
            } else if (c >= '0' && c <= '9') {
                k = k * 10 + c - '0'; //如果k是多位数需要x10
            } else {
                res.append(c); //如果是字母则缓慢添加
            }
        }
        return res.toString();
    }
}
