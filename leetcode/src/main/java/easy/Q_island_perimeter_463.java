package medium;

public class Q_island_perimeter_463 {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    //只与海洋或者边界接壤则代表周长，比如这里的1，它对应计入周长的边，是向上dfs（网格），向左（海洋），向右（海洋），向下（陆地，不计入周长）
    // 0[1]0 0
    // 1 1 1 0
    private int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) return 1; //边界接壤，,因为dfs是上下左右递归的，存在越界，先污染后治理（类似二叉树思维）
        if (grid[r][c] == 0) return 1; //海洋接壤
        if (grid[r][c] != 1) return 0; //否则访问的是已遍历过的陆地，因此不重复计入
        grid[r][c] = 2; //标记已遍历过
        return dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
