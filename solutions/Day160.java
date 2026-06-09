class Day160 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int firstNumber = 0;
        int secondNumber = 1;
        int thirdNumber = 1;
        for (int i = 3; i <= n; i++) {
            int currentNumber = firstNumber + secondNumber + thirdNumber;
            firstNumber = secondNumber;
            secondNumber = thirdNumber;
            thirdNumber = currentNumber;
        }
        return thirdNumber;
    }
}