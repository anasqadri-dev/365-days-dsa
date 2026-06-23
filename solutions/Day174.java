public class Day174 {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generate(answer, "", 0, 0, n);
        return answer;
    }
    private void generate(List<String> answer, String currentString, int openBrackets, int closeBrackets, int totalPairs) {
        if (currentString.length() == totalPairs * 2) {
            answer.add(currentString);
            return;
        }
        if (openBrackets < totalPairs) generate(answer, currentString + "(", openBrackets + 1, closeBrackets, totalPairs);
        if (closeBrackets < openBrackets) generate(answer, currentString + ")", openBrackets, closeBrackets + 1, totalPairs);
    }
}