public class Day99 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        java.util.Deque<Integer> dq = new java.util.LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() == i - k)
                dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1)
                ans[j++] = nums[dq.peekFirst()];
        }
        return ans;
    }
}