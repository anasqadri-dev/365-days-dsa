class Day130 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            ListNode temp = dummy;
            while (temp.next != null && temp.next.val < curr.val)
                temp = temp.next;
            curr.next = temp.next;
            temp.next = curr;
            curr = nextNode;
        }
        return dummy.next;
    }
}