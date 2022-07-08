class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] Ans = new int[n];
        ArrayDeque<Integer> Stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (Stack.size() > 0 && temperatures[i] >= temperatures[Stack.peek()]) {
                Stack.pop();
            }
            Ans[i] = Stack.size() == 0 ? 0 : Stack.peek() - i;
            Stack.push(i);
        }
        return Ans;
    }
}