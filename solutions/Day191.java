class Day191 {
    private int maximumDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return maximumDiameter;
    }
    private int findHeight(TreeNode currentNode) {
        if (currentNode == null) return 0;
        int leftHeight = findHeight(currentNode.left);
        int rightHeight = findHeight(currentNode.right);
        int currentDiameter = leftHeight + rightHeight;
        if (currentDiameter > maximumDiameter) maximumDiameter = currentDiameter;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}