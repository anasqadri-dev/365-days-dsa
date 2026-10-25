public class Day278 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) return true;
            for (int[] dir : directions) {
                int r = current[0];
                int c = current[1];
                while (r + dir[0] >= 0 && r + dir[0] < m && c + dir[1] >= 0 && c + dir[1] < n && maze[r + dir[0]][c + dir[1]] == 0) {
                    r += dir[0];
                    c += dir[1];
                }
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return false;
    }
}