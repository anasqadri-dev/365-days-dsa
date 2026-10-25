public class Day299 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        union(parent, 0, firstPerson);
        for (int i = 0; i < meetings.length;) {
            int j = i;
            while (j < meetings.length && meetings[j][2] == meetings[i][2]) {
                union(parent, meetings[j][0], meetings[j][1]);
                j++;
            }
            for (int k = i; k < j; k++) {
                int x = meetings[k][0], y = meetings[k][1];
                if (find(parent, x) != find(parent, 0)) parent[x] = x;
                if (find(parent, y) != find(parent, 0)) parent[y] = y;
            }
            i = j;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (find(parent, i) == find(parent, 0)) result.add(i);
        return result;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}