public class Day148 {
    int[] priceStack;
    int[] spanStack;
    int top;
    public StockSpanner() {
        priceStack = new int[10000];
        spanStack = new int[10000];
        top = -1;
    }
    public int next(int price) {
        int currentSpan = 1;
        while (top != -1 && priceStack[top] <= price) {
            currentSpan = currentSpan + spanStack[top];
            top--;
        }
        top++;
        priceStack[top] = price;
        spanStack[top] = currentSpan;
        return currentSpan;
    }
}