public class Day291 {
    private int[] parent;
    private int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                union(a, b);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                if (find(a) == find(b)) return false;
            }
        }
        return true;
    }
    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}