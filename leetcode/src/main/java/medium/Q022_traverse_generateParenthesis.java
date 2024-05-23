package medium;

import java.util.ArrayList;
import java.util.List;

public class Q022_traverse_generateParenthesis {
    List<String> list = new ArrayList();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return list;
    }

    //剩余( 和 剩余 ）
    public void dfs(int left, int right, String res) {
        if (left == 0 && right == 0) {
            list.add(res);
        }
        if (left > right) { //剪枝
            return;
        }
        //只是传了参数，没有改变当前方法的cur的值,因此可以隐去回溯的过程
        if (left > 0) dfs(left - 1, right, res + "(");
        if (right > 0) dfs(left, right - 1, res + ")");
    }
}
