public class Day178 {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        generatePartitions(s, 0, currentPartition, answer);
        return answer;
    }
    private void generatePartitions(String s, int startIndex, List<String> currentPartition, List<List<String>> answer) {
        if (startIndex == s.length()) {
            answer.add(new ArrayList<>(currentPartition));
            return;
        }
        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            if (isPalindrome(s, startIndex, endIndex)) {
                currentPartition.add(s.substring(startIndex, endIndex + 1));
                generatePartitions(s, endIndex + 1, currentPartition, answer);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}