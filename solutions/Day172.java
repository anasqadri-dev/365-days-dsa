public class Day172 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinations(candidates, target, 0, currentCombination, answer);
        return answer;
    }

    private void generateCombinations(int[] candidates, int remainingTarget, int startIndex,
            List<Integer> currentCombination, List<List<Integer>> answer) {
        if (remainingTarget == 0) {
            answer.add(new ArrayList<>(currentCombination));
            return;
        }
        if (remainingTarget < 0)
            return;
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex &&
                    candidates[i] == candidates[i - 1]) {
                continue;
            }
            currentCombination.add(candidates[i]);
            generateCombinations(candidates, remainingTarget - candidates[i], i + 1, currentCombination, answer);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}