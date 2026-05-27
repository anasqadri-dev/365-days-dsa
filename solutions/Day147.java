class Day147 - Hapy Bakra Eid {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && heights[stack[top]] >= heights[i])
                top--;
            if (top == -1)
                leftSmaller[i] = -1;
            else
                leftSmaller[i] = stack[top];
            top++;
            stack[top] = i;
        }
        top = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (top != -1 && heights[stack[top]] >= heights[i])
                top--;
            if (top == -1)
                rightSmaller[i] = n;
            else
                rightSmaller[i] = stack[top];
            top++;
            stack[top] = i;
        }
        int maximumArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            int currentArea = heights[i] * width;
            if (currentArea > maximumArea)
                maximumArea = currentArea;
        }
        return maximumArea;
    }
}