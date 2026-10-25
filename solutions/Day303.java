public class Day303 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length, result = n;
        int[] parent = new int[n], rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.sort(edges, (a, b) ->
            Integer.compare(
                Math.max(vals[a[0]], vals[a[1]]),
                Math.max(vals[b[0]], vals[b[1]])
            ));
        for (int[] e : edges) {
            int a = find(parent, e[0]);
            int b = find(parent, e[1]);
            if (a == b) continue;
            if (vals[a] < vals[b]) parent[a] = b;
            else if (vals[a] > vals[b]) parent[b] = a;
            else {
                result += (int) ((long) size[a] * size[b]);
                parent[b] = a;
                size[a] += size[b];
            }
        }
        return result;
    }
    private int[] size = new int[0];
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}