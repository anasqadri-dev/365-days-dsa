public class Day290 {
    private int[] parent;
    private int[] rank;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int groups = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (find(i) != find(j) && isSimilar(strs[i], strs[j])) {
                    union(i, j);
                    groups--;
                }
            }
        }
        return groups;
    }
    private boolean isSimilar(String a, String b) {
        int differences = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differences++;
                if (differences > 2) return false;
            }
        }
        return differences == 0 || differences == 2;
    }
    private int find(int x) {
        if (parent[x] != x)  parent[x] = find(parent[x]);
        return parent[x];
    }
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)  return;
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY])  parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}