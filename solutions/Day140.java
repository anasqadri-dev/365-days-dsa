public class Day140 {
    public int calPoints(String[] operations) {
        int n = operations.length;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            String op = operations[i];
            if (op.equals("+")) {
                int last = stack[top];
                int secondLast = stack[top - 1];
                int newScore = last + secondLast;
                top++;
                stack[top] = newScore;
            }
            else if (op.equals("D")) {
                int newScore = 2 * stack[top];
                top++;
                stack[top] = newScore;
            }
            else if (op.equals("C")) {
                top--;
            }
            else {
                int num = Integer.parseInt(op);
                top++;
                stack[top] = num;
            }
        }
        int sum = 0;
        for (int i = 0; i <= top; i++) {
            sum += stack[i];
        }
        return sum;
    }
}