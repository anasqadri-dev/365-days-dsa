class Day203 {
    private int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootValue);
        int rootPosition = startIndex;
        while (rootPosition <= endIndex) {
            if (inorder[rootPosition] == rootValue) break;
            rootPosition++;
        }
        root.left = build(preorder, inorder, startIndex, rootPosition - 1);
        root.right = build(preorder, inorder, rootPosition + 1, endIndex);
        return root;
    }
}