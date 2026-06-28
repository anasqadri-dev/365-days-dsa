public class Day179 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinations(1, n, k, currentCombination, answer);
        return answer;
    }
    private void generateCombinations(int currentNumber, int totalNumbers, int requiredNumbers, List<Integer> currentCombination, List<List<Integer>> answer) {
        if (currentCombination.size() == requiredNumbers) {
            answer.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int number = currentNumber; number <= totalNumbers; number++) {
            currentCombination.add(number);
            generateCombinations(number + 1, totalNumbers, requiredNumbers, currentCombination, answer);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}