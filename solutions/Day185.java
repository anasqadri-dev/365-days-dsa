class Day185 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        traverse(root, answer);
        return answer;
    }
    private void traverse(TreeNode currentNode, List<Integer> answer) {
        if (currentNode == null) return;
        traverse(currentNode.left, answer);
        traverse(currentNode.right, answer);
        answer.add(currentNode.val);
    }
}