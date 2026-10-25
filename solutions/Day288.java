public class Day288 {
    private int[] parent;
    private int[] rank;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        Map<String, Integer> emailToAccount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccount.containsKey(email)) union(i, emailToAccount.get(email));
                else emailToAccount.put(email, i);
            }
        }
        Map<Integer, TreeSet<String>> mergedEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            int root = find(entry.getValue());
            mergedEmails.computeIfAbsent(root, k -> new TreeSet<>()).add(entry.getKey());
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : mergedEmails.entrySet()) {
            int root = entry.getKey();
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(root).get(0));
            mergedAccount.addAll(entry.getValue());
            result.add(mergedAccount);
        }
        return result;
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