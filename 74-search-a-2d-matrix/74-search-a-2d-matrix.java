class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_start, col_start, n, m;
        n = matrix.length;
        m = matrix[0].length;
        row_start = 0;
        col_start = m - 1;
        while (row_start < n && col_start >= 0) {
            if (matrix[row_start][col_start] == target) {
                return true;
            }
            if (matrix[row_start][col_start] > target) {
                col_start--;
            } else {
                row_start++;
            }
        }
        return false;
    }
}