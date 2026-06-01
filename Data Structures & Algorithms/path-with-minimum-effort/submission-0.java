

class Pair {
    int effort;
    int r;
    int c;

    Pair(int effort, int r, int c) {
        this.effort = effort;
        this.r = r;
        this.c = c;
    }
}

class Solution {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.effort - b.effort);

        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int effort = curr.effort;
            int r = curr.r;
            int c = curr.c;

            // Destination reached
            if (r == n - 1 && c == m - 1) {
                return effort;
            }

            // Skip stale entries
            if (effort > dist[r][c]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nr = r + drow[k];
                int nc = c + dcol[k];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                int diff = Math.abs(
                        heights[r][c] - heights[nr][nc]
                );

                int newEffort = Math.max(effort, diff);

                if (newEffort < dist[nr][nc]) {

                    dist[nr][nc] = newEffort;

                    pq.offer(
                            new Pair(newEffort, nr, nc)
                    );
                }
            }
        }

        return 0;
    }
}