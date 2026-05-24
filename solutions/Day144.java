class Day144 {
    public String decodeString(String s) {
        int[] numberStack = new int[1000];
        String[] stringStack = new String[1000];
        int numberTop = -1;
        int stringTop = -1;
        String currentString = "";
        int currentNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (currentCharacter >= '0' && currentCharacter <= '9') {
                currentNumber = currentNumber * 10 + (currentCharacter - '0');
            } else if (currentCharacter == '[') {
                numberTop++;
                numberStack[numberTop] = currentNumber;
                stringTop++;
                stringStack[stringTop] = currentString;
                currentNumber = 0;
                currentString = "";
            }
            else if (currentCharacter == ']') {
                int repeatTimes = numberStack[numberTop];
                numberTop--;
                String previousString = stringStack[stringTop];
                stringTop--;
                String repeatedString = "";
                for (int j = 0; j < repeatTimes; j++) {
                    repeatedString = repeatedString + currentString;
                }
                currentString = previousString + repeatedString;
            }
            else {
                currentString = currentString + currentCharacter;
            }
        }
        return currentString;
    }
}