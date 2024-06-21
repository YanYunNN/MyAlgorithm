package medium;

public class Q_island_maxArea_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) { //是岛屿
                    int area = area(grid, r, c);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) return 0; //边界
        if (grid[r][c] != 1) return 0; //不是陆地或者被标记
        grid[r][c] = 2; //标记已遍历过
        return 1 + area(grid, r + 1, c) + area(grid, r - 1, c) +
                area(grid, r, c + 1) + area(grid, r, c - 1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
