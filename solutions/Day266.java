public class Day266 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            result[i] = dfs(start, end, graph, new ArrayList<>());
        }
        return result;
    }
    private double dfs(String current, String target, Map<String, Map<String, Double>> graph, List<String> visited) {
        if (!graph.containsKey(current) || !graph.containsKey(target)) return -1.0;
        if (current.equals(target)) return 1.0;
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);
        for (String next : neighbors.keySet()) {
            if (visited.contains(next)) continue;
            double result = dfs(next, target, graph, visited);
            if (result != -1.0) return neighbors.get(next) * result;
        }
        return -1.0;
    }
}