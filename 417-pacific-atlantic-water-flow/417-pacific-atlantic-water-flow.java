class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> Ans = new ArrayList<>();
        int n, m;
        int[][] Atlantic, Pacific;
        n = heights.length;
        m = heights[0].length;
        Atlantic = new int[n][m];
        Pacific = new int[n][m];
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                if (row == 0 || col == 0) {
                    dfs(heights, row, col, Pacific, -1);
                }
                if (row == n - 1 || col == m - 1) {
                    dfs(heights, row, col, Atlantic, -1);
                }
            }
        }
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                if (Atlantic[row][col] == 1 && Pacific[row][col] == 1) {
                    Ans.add(Arrays.asList(row, col));
                }
            }
        }
        return Ans;
    }
    
    public void dfs(int[][] Grid, int row, int col, int[][] Vals, int parent) {
        int n = Grid.length;
        int m = Grid[0].length;
        if (
            row == n ||
            col == m ||
            row < 0 ||
            col < 0 ||
            Grid[row][col] < parent ||
            Vals[row][col] > 0
        ) {
            return;
        }
        Vals[row][col] = 1;
        dfs(Grid, row + 1, col, Vals, Grid[row][col]);
        dfs(Grid, row - 1, col, Vals, Grid[row][col]);
        dfs(Grid, row, col + 1, Vals, Grid[row][col]);
        dfs(Grid, row, col - 1, Vals, Grid[row][col]);
    }
}