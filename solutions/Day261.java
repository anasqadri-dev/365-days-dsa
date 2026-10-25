public class Day261 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        for (int i = 0; i < n; i++)
            if (!visited[i]) return false;
        return true;
    }
    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) return;
        visited[room] = true;
        for (int i = 0; i < rooms.get(room).size(); i++) {
            int nextRoom = rooms.get(room).get(i);
            if (!visited[nextRoom]) dfs(nextRoom, rooms, visited);
        }
    }
}