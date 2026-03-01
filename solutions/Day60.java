public class Day60 {
    public int splitArray(int[] nums, int k) {
        return solve(nums, 0, k);
    }
    int solve(int[] nums, int start, int k) {
        if (k == 1) {
            int sum = 0;
            for (int i = start; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum;
        }
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = start; i <= nums.length - k; i++) {
            sum += nums[i];
            int next = solve(nums, i + 1, k - 1);
            int largest = Math.max(sum, next);
            answer = Math.min(answer, largest);
        }
        return answer;
    }
}