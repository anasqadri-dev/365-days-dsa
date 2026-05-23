public class Day142 {
    public String removeOuterParentheses(String s) {
        String answer = "";
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
                if (openCount > 1)
                    answer = answer + s.charAt(i);
            }
            else {
                openCount--;
                if (openCount > 0)
                    answer = answer + s.charAt(i);
            }
        }
        return answer;
    }
}