package medium;

import java.util.Stack;

/**
 * @author xcai
 * @date 2025/02/14
 * @see <a href=''>Conf<a/>
 *
 * 示例 1：
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：
 * 应删除尾随斜杠。
 *
 * 示例 2：
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：
 * 多个连续的斜杠被单个斜杠替换。
 *
 * 示例 3：
 * 输入：path = "/home/user/Documents/../Pictures"
 * 输出："/home/user/Pictures"
 * 解释：
 * 两个点 ".." 表示上一级目录（父目录）。
 *
 * 示例 4：
 * 输入：path = "/../"
 * 输出："/"
 */
public class Q071_simplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.equals("..")) { //这里条件不能合并，因为当part为".."且栈为空时，由于不满足合并后的条件，代码流会继续检查else if的条件
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
