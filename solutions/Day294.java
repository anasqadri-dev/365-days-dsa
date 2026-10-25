public class Day294 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> result = new ArrayList<>();
        int islands = 0;
        for (int[] pos : positions) {
            int r = pos[0], c = pos[1], id = r * n + c;
            if (parent[id] != -1) {
                result.add(islands);
                continue;
            }
            parent[id] = id;
            islands++;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                int neighbor = nr * n + nc;
                if (parent[neighbor] == -1) continue;
                int rootA = find(parent, id);
                int rootB = find(parent, neighbor);
                if (rootA != rootB) {
                    parent[rootA] = rootB;
                    islands--;
                }
            }
            result.add(islands);
        }
        return result;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}