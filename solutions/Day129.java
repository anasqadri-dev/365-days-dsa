class Day129 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int total = 0;
        ListNode temp = head;
        while (temp != null) {
            total++;
            temp = temp.next;
        }
        int partSize = total / k;
        int extra = total % k;
        temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                ans[i] = null;
                continue;
            }
            ans[i] = temp;
            int currentSize = partSize;
            if (extra > 0) {
                currentSize++;
                extra--;
            }
            for (int j = 1; j < currentSize; j++)
                temp = temp.next;
            ListNode nextPart = temp.next;
            temp.next = null;
            temp = nextPart;
        }
        return ans;
    }
}