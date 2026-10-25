public class Day280 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            graph[u].add(new int[]{v, cnt + 1});
            graph[v].add(new int[]{u, cnt + 1});
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];
            if (dist > distance[node]) continue;
            for (int[] next : graph[node]) {
                int neighbor = next[0];
                int cost = next[1];
                int newDist = dist + cost;
                if (newDist < distance[neighbor]) {
                    distance[neighbor] = newDist;
                    pq.offer(new int[]{neighbor, newDist});
                }
            }
        }
        int reachable = 0;
        for (int dist : distance) {
            if (dist <= maxMoves) reachable++;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            int fromU = distance[u] == Integer.MAX_VALUE ? 0 : Math.max(0, maxMoves - distance[u]);
            int fromV = distance[v] == Integer.MAX_VALUE ? 0 : Math.max(0, maxMoves - distance[v]);
            reachable += Math.min(cnt, fromU + fromV);
        }
        return reachable;
    }
}