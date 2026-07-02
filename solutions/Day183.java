class Day183 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        traverse(root, answer);
        return answer;
    }
    private void traverse(TreeNode currentNode, List<Integer> answer) {
        if (currentNode == null) return;
        answer.add(currentNode.val);
        traverse(currentNode.left, answer);
        traverse(currentNode.right, answer);
    }
}