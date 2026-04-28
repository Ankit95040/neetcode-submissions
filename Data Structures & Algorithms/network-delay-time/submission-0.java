class Pair {
    int dis;
    int node;

    public Pair(int dis, int node) {
        this.dis = dis;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // build graph
        for (int[] t : times) {
            int s = t[0] - 1;
            int d = t[1] - 1;
            int time = t[2];

            list.get(s).add(new Pair(time, d));
        }

        int[] vis = new int[n];
        Arrays.fill(vis, (int) 1e9);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dis - b.dis);

        pq.add(new Pair(0, k - 1));
        vis[k - 1] = 0;

        while (!pq.isEmpty()) {

            Pair temp = pq.poll();

            int dis = temp.dis;
            int node = temp.node;

            for (Pair p : list.get(node)) {

                int dist = p.dis;
                int next = p.node;

                if (dis + dist < vis[next]) {

                    vis[next] = dis + dist;

                    pq.add(new Pair(vis[next], next));
                }
            }
        }

        int max = 0;

        for (int i : vis) {

            if (i == (int) 1e9) {
                return -1;
            }

            max = Math.max(max, i);
        }

        return max;
    }
}