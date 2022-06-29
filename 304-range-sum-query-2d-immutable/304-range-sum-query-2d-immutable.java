class NumMatrix {
    private int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int n, m;
        n = matrix.length;
        m = matrix[0].length;
        prefixSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    prefixSum[i][j] = matrix[i][j];
                } else {
                    prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // System.out.println(prefixSum[0][0]);
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            if (col1 == 0) {
                sum += prefixSum[row][col2];
            } else {
                sum += (prefixSum[row][col2] - prefixSum[row][col1 - 1]);
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */