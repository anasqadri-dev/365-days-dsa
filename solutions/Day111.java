public class Day111 {
    public int size(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        int size = size(head);
        if (n == size) {
            head = head.next;
            return head;
        }
        if (n > size) return head;
        int iteration = size - n;
        ListNode current = head;
        for (int i = 1; i < iteration; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}