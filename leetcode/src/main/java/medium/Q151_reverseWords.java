package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xcai
 * @date 2025/02/12
 * @see <a href=''>Conf<a/>
 *
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 *
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 */
public class Q151_reverseWords {
    public String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);

        StringBuilder result = new StringBuilder();
        for (String word : wordList) {
            result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i; //移动右指针
        }
        return sb.toString().trim();
    }
}
