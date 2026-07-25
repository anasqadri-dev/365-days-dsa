class Day206 {
    private int maximumPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaximumPath(root);
        return maximumPathSum;
    }
    private int findMaximumPath(TreeNode currentNode) {
        if (currentNode == null) return 0;
        int leftPath = Math.max(0, findMaximumPath(currentNode.left));
        int rightPath = Math.max(0, findMaximumPath(currentNode.right));
        int currentPathSum = currentNode.val + leftPath + rightPath;
        if (currentPathSum > maximumPathSum) maximumPathSum = currentPathSum;
        return currentNode.val + Math.max(leftPath, rightPath);
    }
}