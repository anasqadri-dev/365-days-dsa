public class Day132 {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int maxVal = head.val;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val < maxVal) temp.next = temp.next.next;
            else {
                temp = temp.next;
                maxVal = temp.val;
            }
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}