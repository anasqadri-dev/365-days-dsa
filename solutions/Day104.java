public class Day104 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        java.util.Deque<Integer> q = new java.util.ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k) {
                ans = Math.min(ans, i - q.pollFirst());
            }
            while (!q.isEmpty() && sum[i] <= sum[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}