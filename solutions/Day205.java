public class Day205 {
    private int currentIndex = 0;
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        buildString(root, result);
        return result.toString();
    }
    private void buildString(TreeNode currentNode, StringBuilder result) {
        if (currentNode == null) {
            result.append("#,");
            return;
        }
        result.append(currentNode.val).append(",");
        buildString(currentNode.left, result);
        buildString(currentNode.right, result);
    }
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        currentIndex = 0;
        return buildTree(values);
    }
    private TreeNode buildTree(String[] values) {
        if (values[currentIndex].equals("#")) {
            currentIndex++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[currentIndex]));
        currentIndex++;
        root.left = buildTree(values);
        root.right = buildTree(values);
        return root;
    }
}