class Day167 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> currentPermutation = new ArrayList<>();
        generatePermutations(nums, used, currentPermutation, answer);
        return answer;
    }
    private void generatePermutations(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> answer) {
        if (currentPermutation.size() == nums.length) {
            answer.add(new ArrayList<>(currentPermutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            currentPermutation.add(nums[i]);
            generatePermutations(nums, used, currentPermutation, answer);
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }
}