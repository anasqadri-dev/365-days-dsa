class Day119 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (true) {
            ListNode check = prev;
            for (int i = 0; i < k; i++) {
                check = check.next;
                if (check == null) return dummy.next;
            }
            ListNode curr = prev.next;
            ListNode nextNode = null;
            for (int i = 0; i < k - 1; i++) {
                nextNode = curr.next;
                curr.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
            }
            prev = curr;
        }
    }
}