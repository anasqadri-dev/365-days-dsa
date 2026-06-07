class Day158 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] stack = new int[n + 1];
        int top = -1;
        int maximumLength = 0;
        top++;
        stack[top] = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                top++;
                stack[top] = i;
            } else {
                top--;
                if (top == -1) {
                    top++;
                    stack[top] = i;
                } else {
                    int currentLength = i - stack[top];
                    if (currentLength > maximumLength) {
                        maximumLength = currentLength;
                    }
                }
            }
        }
        return maximumLength;
    }
}