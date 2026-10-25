public class Day286 {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effort = new int[rows][cols];
        for (int[] row : effort)
            Arrays.fill(row, Integer.MAX_VALUE);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        effort[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];
            int currentEffort = current[2];
            if (currentEffort > effort[r][c]) continue;
            if (r == rows - 1 && c == cols - 1) return currentEffort;
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int difference = Math.abs(heights[r][c] - heights[nr][nc]);
                    int newEffort = Math.max(currentEffort, difference);
                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}