class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> ratings[a] - ratings[b]);
        for (int i = 0; i < n; i++) {
          pq.offer(i);
        }
        while (!pq.isEmpty()) {
          int idx = pq.poll();
          if (idx == 0) {
            if (ratings[idx] > ratings[idx + 1]) {
              candies[idx] = candies[idx + 1] + 1;
            }
          } else if (idx == n - 1) {
            if (ratings[idx] > ratings[idx - 1]) {
              candies[idx] = candies[idx - 1] + 1;
            }
          } else {
            if (ratings[idx] > ratings[idx - 1] || ratings[idx] > ratings[idx + 1]) {
              if (ratings[idx] == ratings[idx - 1] || ratings[idx] == ratings[idx + 1]) {
                if (ratings[idx] == ratings[idx - 1]) {
                  candies[idx] = candies[idx + 1] + 1;
                } else {
                  candies[idx] = candies[idx - 1] + 1;
                }
              } else if (ratings[idx] > ratings[idx + 1] && ratings[idx] > ratings[idx - 1]) {
                  int high = candies[idx + 1] > candies[idx - 1] ? idx + 1 : idx - 1;
                  candies[idx] = candies[high] + 1;
              } else {
                  if (ratings[idx] > ratings[idx + 1]) {
                      candies[idx] = candies[idx + 1] + 1;
                  } else {
                      candies[idx] = candies[idx - 1] + 1;
                  }
              }
            }
          }
        }
        int Ans = 0;
        for (int c : candies) {
          System.out.print(c + " ");
          Ans += c;
        }
        return Ans;
    }
}