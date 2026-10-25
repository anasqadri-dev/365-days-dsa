public class Day263 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(i, 1, graph, color)) return false;
        }
        return true;
    }
    private boolean dfs(int node, int currentColor, int[][] graph, int[] color) {
        color[node] = currentColor;
        for (int i = 0; i < graph[node].length; i++) {
            int next = graph[node][i];
            if (color[next] == 0) {
                if (!dfs(next, -currentColor, graph, color)) return false;
            } else if (color[next] == currentColor) {
                return false;
            }
        }
        return true;
    }
}