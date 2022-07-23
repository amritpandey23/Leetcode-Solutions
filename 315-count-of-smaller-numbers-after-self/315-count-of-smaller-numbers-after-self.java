class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n;
        Pair[] A;
        List<Integer> Ans;
        
        n = nums.length;
        A = new Pair[n];
        Ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            A[i] = new Pair(nums[i], i);
        }
        mergeSort(A, 0, n - 1);
        Arrays.sort(A, (a, b) -> a.idx - b.idx);
        for (Pair x : A) {
            Ans.add(x.count);
        }
        return Ans;
    }
    
    private void mergeSort(Pair[] A, int l, int h) {
        if (l < h) {
            int m = l + (h - l) / 2;
            mergeSort(A, l, m);
            mergeSort(A, m + 1, h);
            countAndMerge(A, l, m, h);
        }
    }
    
    private void countAndMerge(Pair[] A, int l, int m, int h) {
        int n1, n2, i, j, k;
        Pair[] left, right;
        n1 = m - l + 1;
        n2 = h - m;
        left = new Pair[n1];
        right = new Pair[n2];
        i = j = 0;
        for (i = 0; i < n1; ++i) {
            left[i] = A[l + i];
        }
        for (j = 0; j < n2; ++j) {
            right[j] = A[m + j + 1];
        }
        i = j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (left[i].val > right[j].val) {
                left[i].count += n2 - j;
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }
        while (i < n1) {
            A[k++] = left[i++];
        }
        while (j < n2) {
            A[k++] = right[j++];
        }
    }
    
    private class Pair {
        int val;
        int count;
        int idx;
        
        Pair(int val, int idx) {
            this.val = val;
            this.count = 0;
            this.idx = idx;
        }
    }
}