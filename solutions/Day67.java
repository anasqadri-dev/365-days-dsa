public class Day67 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        sortArray(nums);
        int longest = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] == nums[i - 1] + 1) count++;
            else count = 1;
            if (count > longest) longest = count;
        }
        return longest;
    }
    public void sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}