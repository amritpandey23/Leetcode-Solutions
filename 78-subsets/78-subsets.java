class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        generate(0, nums, new ArrayList<>());
        return Ans;
    }
    
    private List<List<Integer>> Ans = new ArrayList<>();
    
    private void generate(int i, int[] nums, List<Integer> subset) {
        if (i == nums.length) {
            Ans.add(new ArrayList<>(subset));
            return;
        }
        generate(i + 1, nums, subset);
        subset.add(nums[i]);
        generate(i + 1, nums, subset);
        subset.remove(subset.size() - 1);
    }
}