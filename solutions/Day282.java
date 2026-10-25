public class Day282 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int longest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                longest = Math.max(longest, dfs(matrix, memo, i, j));
        }
        return longest;
    }
    private int dfs(int[][] matrix, int[][] memo, int r, int c) {
        if (memo[r][c] != 0) return memo[r][c];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int longest = 1;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c])
                longest = Math.max(longest, 1 + dfs(matrix, memo, nr, nc));
        }
        memo[r][c] = longest;
        return longest;
    }
}