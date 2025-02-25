package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q051_NQueens {
    List<List<String>> result = new ArrayList<>();

    /* 输入棋盘边长 n，返回所有合法的放置 */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] rows : board) {
            Arrays.fill(rows, '.');
        }
        backtrack(n, board, 0);
        return result;
    }


    private void backtrack(int n, char[][] board, int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] rows : board) {
                list.add(new String(rows));
            }
            result.add(list);
        }
        for (int col = 0; col < n; col++) {
            if (!valid(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack(n, board, row + 1);
            board[row][col] = '.';
        }
    }

    // 皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子
    private boolean valid(char[][] board, int row, int col) {
        /* 由于递归的原因，同行不会放俩个皇后，只需要检查到当前行同列是否有皇后互相冲突*/
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        /* 检查左上方对角线*/
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }
        /* 检查右上方对角线*/
        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }
        return true;
    }
}
