class Day109 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);        
        int left = 0;
        long total = 0;
        int ans = 1;
        for (int right = 0; right < nums.length; right++) {
            total = total + nums[right];
            while ((long)nums[right] * (right - left + 1) > total + k) {
                total = total - nums[left];
                left = left + 1;
            }
            int windowSize = right - left + 1;
            if (windowSize > ans)
                ans = windowSize;
        }
        return ans;
    }
}