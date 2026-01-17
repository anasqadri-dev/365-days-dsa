class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Day08 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        boolean isPalindrome = false;
        ListNode mid = middleNode(head);
        ListNode headSecond = reverse(mid);
        ListNode reverseHead = headSecond;
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) return false;
            head = head.next;
            headSecond = headSecond.next;
        }
        return true;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
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