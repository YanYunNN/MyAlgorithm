package medium;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/">leetcode岛屿问题<a/>
 */
public class Q_island_num_200 {
    //leetcode submit region begin(Prohibit modification and deletion)
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);//深度遍历后，已走过的岛屿变成了2
                    res++;
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) return;
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2'; // 将格子标记为「已遍历过」
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
//leetcode submit region end(Prohibit modification and deletion)
}
