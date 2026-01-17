public ListNode middleNode(ListNode head) {
    if (head == null) {
        return head;
    }
    ListNode slow, fast;
    slow = fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}