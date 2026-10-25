public class Day296 {
    int[] parent, rank;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] e = new int[m][4];
        for (int i = 0; i < m; i++)
            e[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        Arrays.sort(e, (a, b) -> Integer.compare(a[2], b[2]));
        int mst = kruskal(n, e, -1, -1);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (kruskal(n, e, i, -1) > mst) critical.add(e[i][3]);
            else if (kruskal(n, e, -1, i) == mst) pseudo.add(e[i][3]);
        }
        return Arrays.asList(critical, pseudo);
    }
    private int kruskal(int n, int[][] edges, int skip, int force) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int weight = 0, count = 0;
        if (force != -1) {
            int[] e = edges[force];
            union(e[0], e[1]);
            weight += e[2];
            count++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == skip || i == force) continue;
            int[] e = edges[i];
            if (union(e[0], e[1])) {
                weight += e[2];
                count++;
            }
        }
        return count == n - 1 ? weight : Integer.MAX_VALUE;
    }
    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    private boolean union(int x, int y) {
        int a = find(x), b = find(y);
        if (a == b) return false;
        if (rank[a] < rank[b]) parent[a] = b;
        else if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[b] = a;
            rank[a]++;
        }
        return true;
    }
}