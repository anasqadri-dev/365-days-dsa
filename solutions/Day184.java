class Day184 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        traverse(root, answer);
        return answer;
    }
    private void traverse(TreeNode currentNode, List<Integer> answer) {
        if (currentNode == null) return;
        traverse(currentNode.left, answer);
        answer.add(currentNode.val);
        traverse(currentNode.right, answer);
    }
}