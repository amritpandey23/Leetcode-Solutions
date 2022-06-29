class Solution {
    public int totalNQueens(int n) {
        int[] column = new int[n];
        int[] diag1 = new int[2 * n];
        int[] diag2 = new int[2 * n];
        int[][] board = new int[n][n];
        return solve(0, n, column, diag1, diag2);
    }
    
    public int solve(int row, int n, int[] column, int[] diag1, int[] diag2) {
        if (row == n) {
            return 1;
        }
        int ans = 0;
        for (int col = 0; col < n; col++) {
            if (column[col] == 1 || diag1[row + col] == 1 || diag2[col - row + n - 1] == 1) {
                continue;
            }
            column[col] = diag1[row + col] = diag2[col - row + n - 1] = 1;
            ans += solve(row + 1, n, column, diag1, diag2);
            column[col] = diag1[row + col] = diag2[col - row + n - 1] = 0;
        }
        return ans;
    }
}