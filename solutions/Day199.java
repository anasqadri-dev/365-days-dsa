class Day199 {
    private int count = 0;
    private int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k);
        return answer;
    }
    private void findKthSmallest(TreeNode currentNode, int k) {
        if (currentNode == null) return;
        findKthSmallest(currentNode.left, k);
        count++;
        if (count == k) {
            answer = currentNode.val;
            return;
        }
        findKthSmallest(currentNode.right, k);
    }
}