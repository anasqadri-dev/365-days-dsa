public class Day277 {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int startRow = 0, startCol = 0, keyCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    startRow = i;
                    startCol = j;
                }
                if (ch >= 'a' && ch <= 'f') keyCount++;
            }
        }
        int target = (1 << keyCount) - 1;
        boolean[][][] visited = new boolean[m][n][1 << keyCount];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol][0] = true;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] state = queue.poll();
                int r = state[0], c = state[1], keys = state[2];
                if (keys == target) return steps;
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    char ch = grid[nr].charAt(nc);
                    if (ch == '#') continue;
                    if (ch >= 'A' && ch <= 'F' && (keys & (1 << (ch - 'A'))) == 0) continue;
                    int newKeys = keys;
                    if (ch >= 'a' && ch <= 'f') newKeys |= 1 << (ch - 'a');
                    if (!visited[nr][nc][newKeys]) {
                        visited[nr][nc][newKeys] = true;
                        queue.add(new int[]{nr, nc, newKeys});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}