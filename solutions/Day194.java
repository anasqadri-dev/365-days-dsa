class Day194 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root == null) return answer;
        findPaths(root, "", answer);
        return answer;
    }
    private void findPaths(TreeNode currentNode, String currentPath, List<String> answer) {
        if (currentNode == null) return;
        if (currentPath.isEmpty()) currentPath = String.valueOf(currentNode.val);
        else currentPath = currentPath + "->" + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) {
            answer.add(currentPath);
            return;
        }
        findPaths(currentNode.left, currentPath, answer);
        findPaths(currentNode.right, currentPath, answer);
    }
}