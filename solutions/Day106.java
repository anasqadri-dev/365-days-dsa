class Day106 {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLen = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                zeroCount++;
            while (zeroCount > 1) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }
            int currentSize = right - left;
            if (currentSize > maxLen)
                maxLen = currentSize;
            right++;
        }
        return maxLen;
    }
}