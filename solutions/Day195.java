class Day195 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, answer);
        return answer;
    }
    private void findPaths(TreeNode currentNode, int remainingSum, List<Integer> currentPath, List<List<Integer>> answer) {
        if (currentNode == null) return;
        currentPath.add(currentNode.val);
        remainingSum = remainingSum - currentNode.val;
        if (currentNode.left == null && currentNode.right == null && remainingSum == 0) {
            answer.add(new ArrayList<>(currentPath));
        } else {
            findPaths(currentNode.left, remainingSum, currentPath, answer);
            findPaths(currentNode.right, remainingSum, currentPath, answer);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}