public class Day98 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroCount++;
            while (zeroCount > k) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }
            int windowSize = right - left + 1;
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }
}