class Day126 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstK = head;
        for (int i = 1; i < k; i++)
            firstK = firstK.next;
        ListNode secondK = head;
        ListNode temp = firstK;
        while (temp.next != null) {
            temp = temp.next;
            secondK = secondK.next;
        }
        int tempVal = firstK.val;
        firstK.val = secondK.val;
        secondK.val = tempVal;
        return head;
    }
}