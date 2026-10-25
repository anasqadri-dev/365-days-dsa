public class Day304 {
    class Graph {
        private List<int[]>[] adj;
        public Graph(int n, int[][] edges) {
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++)
                adj[i] = new ArrayList<>();
            for (int[] edge : edges)
                addEdge(edge);
        }
        public void addEdge(int[] edge) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        public int shortestPath(int node1, int node2) {
            int n = adj.length;
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[node1] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{node1, 0});
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int node = current[0];
                int cost = current[1];
                if (cost > dist[node]) continue;
                if (node == node2) return cost;
                for (int[] edge : adj[node]) {
                    int next = edge[0];
                    int newCost = cost + edge[1];
                    if (newCost < dist[next]) {
                        dist[next] = newCost;
                        pq.offer(new int[]{next, newCost});
                    }
                }
            }
            return -1;
        }
    }
}