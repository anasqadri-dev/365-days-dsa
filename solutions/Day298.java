public class Day298 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n), bob = new DSU(n);
        int used = 0;
        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean a = alice.union(e[1], e[2]);
                boolean b = bob.union(e[1], e[2]);
                if (a || b) used++;
            }
        }
        for (int[] e : edges) {
            if (e[0] == 1 && alice.union(e[1], e[2])) used++;
            if (e[0] == 2 && bob.union(e[1], e[2])) used++;
        }
        return alice.components == 1 && bob.components == 1 ? edges.length - used : -1;
    }
    class DSU {
        int[] parent;
        int components;
        DSU(int n) {
            parent = new int[n + 1];
            components = n;
            for (int i = 1; i <= n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int x, int y) {
            int a = find(x), b = find(y);
            if (a == b) return false;
            parent[a] = b;
            components--;
            return true;
        }
    }
}