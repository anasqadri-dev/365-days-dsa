class Day204 {
    private int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        int rootValue = postorder[postorderIndex];
        postorderIndex--;
        TreeNode root = new TreeNode(rootValue);
        int rootPosition = startIndex;
        while (rootPosition <= endIndex) {
            if (inorder[rootPosition] == rootValue) break;
            rootPosition++;
        }
        root.right = build(inorder, postorder, rootPosition + 1, endIndex);
        root.left = build(inorder, postorder, startIndex, rootPosition - 1);
        return root;
    }
}