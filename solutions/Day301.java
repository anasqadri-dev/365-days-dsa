public class Day301 {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        long remaining = n, pairs = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            long size = dfs(i, graph, visited);
            remaining -= size;
            pairs += size * remaining;
        }
        return pairs;
    }
    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int size = 1;
        for (int next : graph.get(node))
            if (!visited[next]) size += dfs(next, graph, visited);
        return size;
    }
}