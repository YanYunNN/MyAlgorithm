package medium;

//leetcode.cn/problems/reverse-words-in-a-string/solutions/2361551/151-fan-zhuan-zi-fu-chuan-zhong-de-dan-c-yb1r/
public class Q151_reverseWords {
    public String reverseWords(String s) {
        s = s.trim();                                    // 删除首尾空格
        int i = s.length() - 1, j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            //找第一个空格
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1) + " ");
            //跳过空格
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i; //i不为空格时
        }
        return sb.toString().trim();
    }
}
