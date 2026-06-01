class Day152 {
    public int evalRPN(String[] tokens) {
        int[] numbers = new int[tokens.length];
        int top = -1;
        for (int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            if (current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/")) {
                int secondNumber = numbers[top];
                top--;
                int firstNumber = numbers[top];
                top--;
                int result = 0;
                if (current.equals("+"))
                    result = firstNumber + secondNumber;
                else if (current.equals("-"))
                    result = firstNumber - secondNumber;
                else if (current.equals("*"))
                    result = firstNumber * secondNumber;
                else
                    result = (int)((double)firstNumber / secondNumber);
                top++;
                numbers[top] = result;
            }
            else {
                top++;
                numbers[top] = Integer.parseInt(current);
            }
        }
        return numbers[top];
    }
}