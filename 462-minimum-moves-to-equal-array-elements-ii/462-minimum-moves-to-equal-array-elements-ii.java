class Solution {
    public int minMoves2(int[] nums) {
        int count = 0;
        int median = nums[partition(nums, 0, nums.length - 1)];
        for (int n : nums) {
            count += Math.abs(n - median);
        }
        return count;
    }
    
    public int partition(int[] A, int l, int h) {
        int i, j;
        final int pivot, randomIdx;
        randomIdx = new Random().nextInt(h - l + 1) + l;
        swap(A, h, randomIdx);
        pivot = A[h];
        i = l - 1;
        j = l;
        while (j < h) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
            j++;
        }
        i++;
        swap(A, i, h);
        if (i == A.length / 2) {
            return i;
        }
        if (i < A.length / 2) {
            return partition(A, i + 1, h);
        }
        return partition(A, l, i - 1);
    }
    
    public void swap(int[] A, int x, int y) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }
}