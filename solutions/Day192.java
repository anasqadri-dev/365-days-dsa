class Day192 {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode currentNode) {
        if (currentNode == null) return 0;
        int leftHeight = checkHeight(currentNode.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(currentNode.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}