package backtrack;

public class Q037_solveSudoku {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    // 递归需要返回值，因为只需要找到一个叶子节点即可
    boolean backtrack(char[][] board) {
        //递归不用终止条件，解数独是要遍历整个树形结构寻找可能的叶子节点就立刻返回
        //递归的下一层的棋盘一定比上一层的棋盘多一个数，等数填满了棋盘自然就终止（填满当然好了，说明找到结果了），所以不需要终止条件！
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue; //有值
                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(board, i, j, k)) continue; //无效
                    board[i][j] = k;
                    if (backtrack(board)) return true;
                    board[i][j] = '.';
                }
                return false; //9个数都试过不行则返回false
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int row, int col, int val) {
        // 数字 1-9 在每一行只能出现一次
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == val) return false;
        }
        // 数字 1-9 在每一列只能出现一次
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == val) return false;
        }
        // 9宫格里是否重复(好几个九宫格，每个都需要满足，因此需要先找到起始的九宫格)
        // 9宫格，数独里面是固定的3*3,不需要每个点都作为9宫格的一部分，因此只需要算出属于那个小9宫格
        int rowStart = row / 3 * 3;
        int colStart = col / 3 * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }
}
