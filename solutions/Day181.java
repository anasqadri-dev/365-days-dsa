public class Day181 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int number : nums)
            totalSum += number;
        if (totalSum % k != 0) return false;
        int targetSum = totalSum / k;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return makeSubsets(nums, used, k, 0, 0, targetSum);
    }
    private boolean makeSubsets(int[] nums, boolean[] used, int remainingSubsets, int startIndex, int currentSum, int targetSum) {
        if (remainingSubsets == 1) return true;
        if (currentSum == targetSum) return makeSubsets(nums, used, remainingSubsets - 1, 0, 0, targetSum);
        for (int i = startIndex; i < nums.length; i++) {
            if (used[i]) continue;
            if (currentSum + nums[i] > targetSum) continue;
            used[i] = true;
            if (makeSubsets(nums, used, remainingSubsets, i + 1, currentSum + nums[i], targetSum)) return true;
            used[i] = false;
        }
        return false;
    }
}