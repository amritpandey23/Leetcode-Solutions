import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return Integer.compare(a.length(), b.length());
                }
                return a.compareTo(b);
            }
        });
        for (String n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}