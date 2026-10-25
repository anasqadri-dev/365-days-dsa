public class Day279 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        distance[start[0]][start[1]] = 0;
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            if (dist > distance[r][c]) continue;
            if (r == destination[0] && c == destination[1]) return dist;
            for (int[] dir : directions) {
                int nr = r;
                int nc = c;
                int steps = 0;
                while (nr + dir[0] >= 0 && nr + dir[0] < m && nc + dir[1] >= 0 && nc + dir[1] < n && maze[nr + dir[0]][nc + dir[1]] == 0) {
                    nr += dir[0];
                    nc += dir[1];
                    steps++;
                }
                int newDist = dist + steps;
                if (newDist < distance[nr][nc]) {
                    distance[nr][nc] = newDist;
                    pq.offer(new int[]{nr, nc, newDist});
                }
            }
        }
        return -1;
    }
}