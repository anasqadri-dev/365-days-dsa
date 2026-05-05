class Day125 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        while (start != null) {
            int sum = 0;
            ListNode end = start.next;
            while (end != null) {
                sum += end.val;
                if (sum == 0) start.next = end.next;
                end = end.next;
            }
            start = start.next;
        }
        return dummy.next;
    }
}