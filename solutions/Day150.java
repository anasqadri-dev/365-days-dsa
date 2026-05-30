class Day150 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] previousSmaller = new int[n];
        int[] nextSmaller = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && arr[stack[top]] > arr[i])
                top--;
            if (top == -1) previousSmaller[i] = -1;
            else previousSmaller[i] = stack[top];
            top++;
            stack[top] = i;
        }
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && arr[stack[top]] >= arr[i])
                top--;
            if (top == -1) nextSmaller[i] = n;
            else nextSmaller[i] = stack[top];
            top++;
            stack[top] = i;
        }
        long answer = 0;
        long MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            long leftCount = i - previousSmaller[i];
            long rightCount = nextSmaller[i] - i;
            long contribution = (long) arr[i] * leftCount * rightCount;
            answer = (answer + contribution) % MOD;
        }
        return (int) answer;
    }
}