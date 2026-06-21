public class Day170 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        generateSubsets(nums, 0, currentSubset, answer);
        return answer;
    }

    private void generateSubsets(int[] nums, int startIndex, List<Integer> currentSubset, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(currentSubset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;
            currentSubset.add(nums[i]);
            generateSubsets(nums, i + 1, currentSubset, answer);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}