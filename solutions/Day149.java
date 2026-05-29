public class Day149 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++)
            answer[i] = -1;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;
            while (top != -1 && nums[currentIndex] > nums[stack[top]]) {
                int previousIndex = stack[top];
                top--;
                answer[previousIndex] = nums[currentIndex];
            }
            if (i < n) {
                top++;
                stack[top] = currentIndex;
            }
        }
        return answer;
    }
}