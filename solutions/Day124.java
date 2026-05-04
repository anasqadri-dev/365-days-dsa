class Day124 {
    public Node flatten(Node head) {
        flattenHelper(head);
        return head;
    }
    private Node flattenHelper(Node head) {
        Node curr = head;
        Node last = null;
        while (curr != null) {
            Node nextNode = curr.next;
            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattenHelper(childHead);
                curr.next = childHead;
                childHead.prev = curr;
                if (nextNode != null) {
                    childTail.next = nextNode;
                    nextNode.prev = childTail;
                }
                curr.child = null;
                last = childTail;
            } else last = curr;
            curr = nextNode;
        }
        return last;
    }
}