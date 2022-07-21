class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                if (row == 0 || row == n - 1 || col == 0 || col == m - 1) {
                    if (board[row][col] == 'O') {
                        dfs(board, row, col);
                    }
                }
            }
        }
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                if (board[row][col] != 'T') {
                    board[row][col] = 'X';
                } else {
                    board[row][col] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] G, int row, int col) {
        int n = G.length;
        int m = G[0].length;
        if (
            row < 0 ||
            col < 0 ||
            row == n ||
            col == m ||
            G[row][col] == 'X' ||
            G[row][col] == 'T'
        ) {
            return;
        }
        G[row][col] = 'T';
        dfs(G, row - 1, col);
        dfs(G, row, col + 1);
        dfs(G, row + 1, col);
        dfs(G, row, col - 1);
    }
}