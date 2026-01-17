public class Day07 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prev, cur, next;
        prev = next = null;
        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
}