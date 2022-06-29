class Solution {
    
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> finalAns = new ArrayList<>();
        int[] column = new int[n];
        int[] diag1 = new int[2 * n];
        int[] diag2 = new int[2 * n];
        int[][] board = new int[n][n];
        solve(0, n, column, diag1, diag2, board, finalAns);
        return finalAns;
    }
    
    public void solve(int row, int n, int[] column, int[] diag1, int[] diag2, int[][] board, List<List<String>> finalAns) {
        if (row == n) {
            List<String> ans = new ArrayList<>();
            for (int[] r : board) {
                String rr = new String();
                for (int c : r) {
                    rr += (c == 1 ? "Q" : ".");
                }
                ans.add(rr);
            }
            finalAns.add(ans);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (column[col] == 1 || diag1[row + col] == 1 || diag2[col - row + n - 1] == 1) {
                continue;
            }
            column[col] = diag1[row + col] = diag2[col - row + n - 1] = 1;
            board[row][col] = 1;
            solve(row + 1, n, column, diag1, diag2, board, finalAns);
            board[row][col] = 0;
            column[col] = diag1[row + col] = diag2[col - row + n - 1] = 0;
        }
    }
}