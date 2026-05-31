class Day151 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int middleValue = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < middleValue) return true;
            while (top != -1 && nums[i] > stack[top]) {
                middleValue = stack[top];
                top--;
            }
            top++;
            stack[top] = nums[i];
        }
        return false;
    }
}