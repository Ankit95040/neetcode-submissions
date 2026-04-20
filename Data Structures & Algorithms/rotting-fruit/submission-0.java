class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Add all rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        int minutes = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int size = q.size();
            int count = 0;   // number of oranges rotted in this minute

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                int r = p.r;
                int c = p.c;

                for (int j = 0; j < 4; j++) {

                    int nr = r + drow[j];
                    int nc = c + dcol[j];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        q.offer(new Pair(nr, nc));
                        count++;   // increment when a fresh orange rots
                    }
                }
            }

            if (count > 0) {
                minutes++;
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return minutes;
    }
}