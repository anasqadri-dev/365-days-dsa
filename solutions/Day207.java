class Day207 {
    class NodeInfo {
        int row;
        int value;
        NodeInfo(int row, int value) {
            this.row = row;
            this.value = value;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<NodeInfo>> columns = new TreeMap<>();
        storeNodes(root, 0, 0, columns);
        List<List<Integer>> answer = new ArrayList<>();
        for (List<NodeInfo> list : columns.values()) {
            Collections.sort(list, (a, b) -> {
                if (a.row != b.row) return a.row - b.row;
                return a.value - b.value;
            });
            List<Integer> currentColumn = new ArrayList<>();
            for (NodeInfo node : list)
                currentColumn.add(node.value);
            answer.add(currentColumn);
        }
        return answer;
    }
    private void storeNodes(TreeNode currentNode, int row, int column, TreeMap<Integer, List<NodeInfo>> columns) {
        if (currentNode == null) return;
        if (!columns.containsKey(column)) columns.put(column, new ArrayList<>());
        columns.get(column).add(new NodeInfo(row, currentNode.val));
        storeNodes(currentNode.left, row + 1, column - 1, columns);
        storeNodes(currentNode.right, row + 1, column + 1, columns);
    }
}