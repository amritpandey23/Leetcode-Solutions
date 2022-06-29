class Solution {
    public int[][] transpose(int[][] matrix) {
        int W, H;
        H = matrix.length;
        W = matrix[0].length;
        if (H == W) {
            for (int i = 0; i < H; i++) {
                for (int j = i + 1; j < W; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            return matrix;
        }
        int[][] ans = new int[W][H];
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }
}