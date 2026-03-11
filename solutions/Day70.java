public class Day70 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] letters = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            letters[c]++;
        }
        int left = 0;
        int right = 0;
        int neededChars = t.length();
        int smallestWindow = Integer.MAX_VALUE;
        int startIndex = 0;
        while (right < s.length()) {
            char currentRightChar = s.charAt(right);
            if (letters[currentRightChar] > 0) neededChars--;
            letters[currentRightChar]--;
            right++;
            while (neededChars == 0) {
                if (right - left < smallestWindow) {
                    smallestWindow = right - left;
                    startIndex = left;
                }
                char currentLeftChar = s.charAt(left);
                letters[currentLeftChar]++;
                if (letters[currentLeftChar] > 0) neededChars++;
                left++;
            }
        }
        if (smallestWindow == Integer.MAX_VALUE) return "";
        return s.substring(startIndex, startIndex + smallestWindow);
    }
}