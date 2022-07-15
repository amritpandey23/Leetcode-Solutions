class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int Ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (grid[row][col] == 1) {
                    Ans = Math.max(Ans, dfs(grid, row, col));
                }
            }
        }
        return Ans;
    }
    
    private int dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (
            row >= m ||
            col >= n ||
            row < 0 ||
            col < 0 ||
            grid[row][col] == 0
        ) {
            return 0;
        }
        grid[row][col] = 0;
        int up = dfs(grid, row - 1, col);
        int right = dfs(grid, row, col + 1);
        int down = dfs(grid, row + 1, col);
        int left = dfs(grid, row, col - 1);
        return 1 + up + right + down + left;
    }
}