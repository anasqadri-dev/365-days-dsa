public class Day264 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph.length - 1, graph, path, result);
        return result;
    }
    private void dfs(int node, int target, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        if (node == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[node].length; i++) {
            int next = graph[node][i];
            path.add(next);
            dfs(next, target, graph, path, result);
            path.remove(path.size() - 1);
        }
    }
}