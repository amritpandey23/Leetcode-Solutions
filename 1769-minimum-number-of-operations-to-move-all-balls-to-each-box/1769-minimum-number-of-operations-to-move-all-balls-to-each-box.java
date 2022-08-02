class Solution {
    public int[] minOperations(String boxes) {
        int n, ballCount;
        int[] leftWays, rightWays, Ans;
        n = boxes.length();
        leftWays = new int[n];
        rightWays = new int[n];
        Ans = new int[n];

        ballCount = boxes.charAt(0) == '1' ? 1 : 0;
        leftWays[0] = 0;
        for (int i = 1; i < n; ++i) {
            leftWays[i] += leftWays[i - 1] + ballCount;
            ballCount += boxes.charAt(i) == '1' ? 1 : 0;
        }
        ballCount = boxes.charAt(n - 1) == '1' ? 1 : 0;
        rightWays[n - 1] = 0;
        for (int i = n - 2; i >= 0; --i) {
            rightWays[i] += rightWays[i + 1] + ballCount;
            ballCount += boxes.charAt(i) == '1' ? 1 : 0;
        }
        for (int i = 0; i < n; ++i) {
            Ans[i] = leftWays[i] + rightWays[i];
        }
        return Ans;
    }
}