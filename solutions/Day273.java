public class Day273 {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }
        int flips = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] == 2) continue;
                    if (grid[r][c] == 1) return flips;
                    grid[r][c] = 2;
                    queue.add(new int[]{r, c});
                }
            }
            flips++;
        }
        return -1;
    }
    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) return;
        grid[r][c] = 2;
        queue.add(new int[]{r, c});
        dfs(grid, r + 1, c, queue);
        dfs(grid, r - 1, c, queue);
        dfs(grid, r, c + 1, queue);
        dfs(grid, r, c - 1, queue);
    }
}