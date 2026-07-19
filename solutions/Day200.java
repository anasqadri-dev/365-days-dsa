class Day200 {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean checkBST(TreeNode currentNode, long minimumValue, long maximumValue) {
        if (currentNode == null) return true;
        if (currentNode.val <= minimumValue || currentNode.val >= maximumValue) return false;
        return checkBST(currentNode.left, minimumValue, currentNode.val) && checkBST(currentNode.right, currentNode.val, maximumValue);
    }
}