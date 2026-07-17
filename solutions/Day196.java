class Day196 {
    public int sumNumbers(TreeNode root) {
        return calculateSum(root, 0);
    }
    private int calculateSum(TreeNode currentNode, int currentNumber) {
        if (currentNode == null) return 0;
        currentNumber = currentNumber * 10 + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) return currentNumber;
        int leftSum = calculateSum(currentNode.left, currentNumber);
        int rightSum = calculateSum(currentNode.right, currentNumber);
        return leftSum + rightSum;
    }
}