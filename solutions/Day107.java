public class Day107 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        int target = totalSum - x;
        if (target < 0) return -1;
        if (target == 0) return n;
        int left = 0;
        int currentSum = 0;
        int maxLength = -1;
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            if (currentSum == target) {
                int length = right - left + 1;
                if (length > maxLength)
                    maxLength = length;
            }
        }
        if (maxLength == -1) return -1;
        return n - maxLength;
    }
}