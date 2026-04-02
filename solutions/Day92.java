class Day92 {
    public int smallestDistancePair(int[] nums, int k) {
        java.util.Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int pairCount = countPairs(nums, mid);
            if (pairCount >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    public int countPairs(int[] nums, int maxDistance) {
        int count,left;
        count = left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDistance)
                left++;
            count += right - left;
        }
        return count;
    }
}