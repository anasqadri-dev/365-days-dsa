public class Day275 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) queue.add(new int[]{i, j});
            }
        }
        if (queue.isEmpty() || queue.size() == n * n) return -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int distance = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return distance;
    }
}