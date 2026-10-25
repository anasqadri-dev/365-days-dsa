public class Day297 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        int[][] q = new int[queries.length][4];
        for (int i = 0; i < queries.length; i++)
            q[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        Arrays.sort(q, (a, b) -> Integer.compare(a[2], b[2]));
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        boolean[] answer = new boolean[queries.length];
        int j = 0;
        for (int[] query : q) {
            while (j < edgeList.length && edgeList[j][2] < query[2]) {
                union(parent, edgeList[j][0], edgeList[j][1]);
                j++;
            }
            answer[query[3]] = find(parent, query[0]) == find(parent, query[1]);
        }
        return answer;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}