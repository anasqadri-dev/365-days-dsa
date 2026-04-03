public class Day93 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < nums.length; i++)
            right = Math.max(right, nums[i]);
        int ans = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            long ops = 0;
            for (int i = 0; i < nums.length; i++)
                ops += (nums[i] - 1) / mid;
            if (ops <= maxOperations) {
                ans = mid; right = mid - 1;
            } else
                left = mid + 1;
        }
        return ans;
    }
}