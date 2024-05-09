package medium;

import java.util.ArrayList;
import java.util.List;

public class Q051_nQueen {
    List<List<String>> res = new ArrayList<>();

    /* 输入棋盘边长 n，返回所有合法的放置 */
    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(List<String> board, int row) {
        if (row == board.size()) { //最后一行则结束
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length(); //列
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) { // 排除不合法选择
                continue;
            }
            StringBuilder str = new StringBuilder(board.get(row));
            str.setCharAt(col, 'Q'); //做选择
            board.set(row, str.toString());

            backtrack(board, row + 1); // 进入下一行决策,row+1 只是计算出一个新的值并传递给下一次递归调用，它并不改变当前的 row 值。而 row++ 或 ++row 则会改变当前的 row 值,影响下面的撤销操作

            str.setCharAt(col, '.');//撤销选择
            board.set(row, str.toString());
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        /* 逐行遍历，检查同列是否有皇后互相冲突 */
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        /* 检查右上方是否有皇后互相冲突 */
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) { //自当前行向右上角挨个检查
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        /* 检查左上方是否有皇后互相冲突 */
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) { //自当前行向左上角挨个检查
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
