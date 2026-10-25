public class Day295 {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int groups = n;
        for (int[] log : logs) {
            int a = find(parent, log[1]);
            int b = find(parent, log[2]);
            if (a == b) continue;
            parent[a] = b;
            if (--groups == 1) return log[0];
        }
        return n == 1 ? 0 : -1;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}