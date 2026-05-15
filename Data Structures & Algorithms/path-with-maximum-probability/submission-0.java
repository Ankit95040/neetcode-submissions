class Pair {
    int node;
    double w;

    public Pair(int node, double w) {
        this.node = node;
        this.w = w;
    }
}

class Solution {
    public double maxProbability(
        int n,
        int[][] edges,
        double[] succProb,
        int start_node,
        int end_node
    ) {
        double[] vis = new double[n];
        Arrays.fill(vis, 0.0);

        List<List<Pair>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] ed = edges[i];
            int s = ed[0];
            int d = ed[1];

            list.get(s).add(new Pair(d, succProb[i]));
            list.get(d).add(new Pair(s, succProb[i]));
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b.w, a.w));

        vis[start_node] = 1.0;
        pq.offer(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();

            double w = temp.w;
            int node = temp.node;

            if (node == end_node) {
                return w;
            }

            for (Pair ele : list.get(node)) {
                double nw = ele.w;
                int nn = ele.node;

                double newProb = w * nw;

                if (newProb > vis[nn]) {
                    vis[nn] = newProb;
                    pq.offer(new Pair(nn, newProb));
                }
            }
        }

        return 0.0;
    }
}