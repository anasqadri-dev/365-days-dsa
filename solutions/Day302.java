public class Day302 {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] r : roads) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }
        return dfs(1, graph, new boolean[n + 1], Integer.MAX_VALUE);
    }
    private int dfs(int node, List<List<int[]>> graph, boolean[] visited, int min) {
        visited[node] = true;
        for (int[] road : graph.get(node)) {
            min = Math.min(min, road[1]);
            if (!visited[road[0]]) min = dfs(road[0], graph, visited, min);
        }
        return min;
    }
}