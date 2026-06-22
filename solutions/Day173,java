class Day173 {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.length() == 0) return answer;
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        generateCombinations(digits, 0, "", mapping, answer);
        return answer;
    }
    private void generateCombinations(String digits, int currentIndex, String currentCombination, String[] mapping, List<String> answer) {
        if (currentIndex == digits.length()) {
            answer.add(currentCombination);
            return;
        }
        int digit = digits.charAt(currentIndex) - '0';
        String letters = mapping[digit];
        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(digits, currentIndex + 1, currentCombination + letters.charAt(i), mapping, answer);
        }
    }
}