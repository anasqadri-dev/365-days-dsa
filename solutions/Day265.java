public class Day265 {
    private Map<Node, Node> cloned = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (cloned.containsKey(node)) return cloned.get(node);
        Node copy = new Node(node.val);
        cloned.put(node, copy);
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node neighbor = node.neighbors.get(i);
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}