class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int [] row : matrix) {
            int i, j;
            i = 0;
            j = n - 1;
            while (i < j) {
                int tmp = row[i];
                row[i] = row[j];
                row[j] = tmp;
                i++;
                j--;
            }
        }
    }
}