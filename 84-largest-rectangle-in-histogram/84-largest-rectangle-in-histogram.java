class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ns = new int[n];
        int[] ps = new int[n];
        nextSmallerElement(heights, ns);
        previousSmallerElement(heights, ps);
        int Ans = 0;
        for (int i = 0; i < n; ++i) {
            int area = heights[i];
            area += (i - (ps[i] + 1)) * heights[i];
            area += ((ns[i] - 1) - i) * heights[i];
            Ans = Math.max(Ans, area);
        }
        return Ans;
    }
    
    public void nextSmallerElement(int[] A, int[] ns) {
        int n = A.length;
        ArrayDeque<Integer> Stack = new ArrayDeque<>();
        for (int i = n - 1; i >=0 ; --i) {
            while (Stack.size() > 0 && A[Stack.peek()] >= A[i]) {
                Stack.pop();
            }
            ns[i] = Stack.size() == 0 ? n : Stack.peek();
            Stack.push(i);
        }
    }
    
    public void previousSmallerElement(int[] A, int[] ps) {
        int n = A.length;
        ArrayDeque<Integer> Stack = new ArrayDeque<>();
        for (int i = 0; i < n ; ++i) {
            while (Stack.size() > 0 && A[Stack.peek()] >= A[i]) {
                Stack.pop();
            }
            ps[i] = Stack.size() == 0 ? -1 : Stack.peek();
            Stack.push(i);
        }
    }
}