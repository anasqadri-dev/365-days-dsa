public class Day285 {
    private int[] parent;
    private int[] rank;
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] connection : connections) {
            int rootU = find(connection[0]);
            int rootV = find(connection[1]);
            if (rootU != rootV) {
                union(rootU, rootV);
                components--;
            }
        }
        return components - 1;
    }
    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    private void union(int x, int y) {
        if (rank[x] < rank[y]) parent[x] = y;
        else if (rank[x] > rank[y]) parent[y] = x;
        else {
            parent[y] = x;
            rank[x]++;
        }
    }
}