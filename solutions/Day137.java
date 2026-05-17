class Day137 {
    int[] mainStack;
    int[] minStack;
    int topIndex;
    int minTopIndex;
    public MinStack() {
        mainStack = new int[10000];
        minStack = new int[10000];
        topIndex = -1;
        minTopIndex = -1;
    }
    public void push(int value) {
        topIndex++;
        mainStack[topIndex] = value;
        if (minTopIndex == -1 || value <= minStack[minTopIndex]) {
            minTopIndex++;
            minStack[minTopIndex] = value;
        }
    }
    public void pop() {
        if (mainStack[topIndex] == minStack[minTopIndex]) minTopIndex--;
        topIndex--;
    }
    public int top() {
        return mainStack[topIndex];
    }
    public int getMin() {
        return minStack[minTopIndex];
    }
}