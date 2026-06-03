public class Day154 {
    public boolean backspaceCompare(String s, String t) {
        char[] firstStack = new char[s.length()];
        char[] secondStack = new char[t.length()];
        int firstTop = -1;
        int secondTop = -1;
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            if (currentCharacter == '#') {
                if (firstTop != -1) firstTop--;
            } else {
                firstTop++;
                firstStack[firstTop] = currentCharacter;
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char currentCharacter = t.charAt(i);
            if (currentCharacter == '#') {
                if (secondTop != -1) secondTop--;
            } else {
                secondTop++;
                secondStack[secondTop] = currentCharacter;
            }
        }
        if (firstTop != secondTop) return false;
        for (int i = 0; i <= firstTop; i++) {
            if (firstStack[i] != secondStack[i]) return false;
        }
        return true;
    }
}