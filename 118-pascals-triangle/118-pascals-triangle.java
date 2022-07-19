class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> r = new ArrayList<>();
            if (i == 0) {
                r.add(1);
                ans.add(r);
            } else {
                r.add(1);
                for (int j = 1; j < i; j++) {
                    r.add(ans.get(ans.size() - 1).get(j - 1) + ans.get(ans.size() - 1).get(j));
                }
                r.add(1);
                ans.add(r);
            }
        }
        
        return ans;
    }
}