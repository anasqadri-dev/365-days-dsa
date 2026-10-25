public class Day267 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] row : graph)
            Arrays.fill(row, -1);
        for (int[] time : times)
            graph[time[0]][time[1]] = time[2];
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        for (int i = 1; i <= n; i++) {
            int current = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] &&
                    (current == -1 || distance[j] < distance[current])) {
                    current = j;
                }
            }
            if (current == -1 || distance[current] == Integer.MAX_VALUE) return -1;
            visited[current] = true;
            for (int next = 1; next <= n; next++) {
                if (!visited[next] && graph[current][next] != -1) {
                    int newDistance = distance[current] + graph[current][next];
                    if (newDistance < distance[next]) distance[next] = newDistance;
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxTime) maxTime = distance[i];
        }
        return maxTime;
    }
}