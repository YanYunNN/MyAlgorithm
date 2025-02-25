package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Q017_letterCombinations {
    List<String> res = new ArrayList<>();
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] numStrs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return res;
        backtrack(digits, 0);
        return res;
    }

    void backtrack(String digits, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = numStrs[digits.charAt(idx) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtrack(digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
