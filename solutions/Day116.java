class Day116 {
    public int size(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) return head;
        int length = size(head);
        int totalRotation = k%length;
        int skip = length - totalRotation;
        if (totalRotation == 0) return head;
        ListNode current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = head;
        current = head;
        for(int i=0; i<skip-1;i++)
            current = current.next;
        head = current.next;
        current.next = null;
        return head;
    }
}