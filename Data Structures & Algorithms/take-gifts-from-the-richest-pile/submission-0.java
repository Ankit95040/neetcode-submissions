class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int n : gifts) {
            pq.add(n);
        }

        for (int i = 0; i < k; i++) {
            int temp = pq.poll();
            pq.add((int)Math.sqrt(temp));
        }

        long ans = 0;

        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        return ans;
    }
}