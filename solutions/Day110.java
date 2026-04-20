class Day110 {
    public int longestSubarray(int[] nums, int limit) {        
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right])
                maxQ.pollLast();
            maxQ.addLast(right);
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right])
                minQ.pollLast();
            minQ.addLast(right);
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                if (maxQ.peekFirst() == left)
                    maxQ.pollFirst();
                if (minQ.peekFirst() == left)
                    minQ.pollFirst();   
                left++;
            }
            int windowSize = right - left + 1;
            if (windowSize > ans)
                ans = windowSize;
        }
        return ans;
    }
}