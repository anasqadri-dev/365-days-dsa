class Day19 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int target[] = new int[nums.length];
        int filled = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = filled; j > index[i]; j--) {
                target[j] = target[j - 1];
            }
            target[index[i]] = nums[i];
            filled++;
        }
        return target;
    }
}