public class Day83 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                int windowLength = right - left + 1;
                minLength = Math.min(minLength, windowLength);
                currentSum -= nums[left];
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;
    }
}