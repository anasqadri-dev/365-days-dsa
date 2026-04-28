class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    int cap;
    HashMap<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if (map.size() > cap) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}