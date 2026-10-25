public class Day300 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long r = bombs[i][2];
                if (i != j && dx * dx + dy * dy <= r * r) graph.get(i).add(j);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dfs(i, graph, new boolean[n]));
        return max;
    }
    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int next : graph.get(node))
            if (!visited[next]) count += dfs(next, graph, visited);
        return count;
    }
}