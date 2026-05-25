class Day145 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
                int previousIndex = stack[top];
                top--;
                answer[previousIndex] = i - previousIndex;
            }
            top++;
            stack[top] = i;
        }
        return answer;
    }
}