public class Day180 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinations(1, k, n, currentCombination, answer);
        return answer;
    }
    private void generateCombinations(int currentNumber, int requiredNumbers, int remainingSum, List<Integer> currentCombination, List<List<Integer>> answer) {
        if (currentCombination.size() == requiredNumbers) {
            if (remainingSum == 0) answer.add(new ArrayList<>(currentCombination));
            return;
        }
        if (remainingSum < 0) return;
        for (int number = currentNumber; number <= 9; number++) {
            currentCombination.add(number);
            generateCombinations(number + 1, requiredNumbers, remainingSum - number, currentCombination, answer);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}