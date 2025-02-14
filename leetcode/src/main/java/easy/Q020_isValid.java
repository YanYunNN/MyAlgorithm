package easy;

import java.util.Stack;

/**
 * @author xcai
 * @date 2025/02/14
 * @see <a href=''>Conf<a/>
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([])"
 * 输出：true
 */
public class Q020_isValid {
    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
