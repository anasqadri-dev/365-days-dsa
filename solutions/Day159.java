public class Day159 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int firstNumber = 0;
        int secondNumber = 1;
        for (int i = 2; i <= n; i++) {
            int currentNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = currentNumber;
        }
        return secondNumber;
    }
}