public class Day120 {
    public int cycleLength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                ListNode temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
            return 0;
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        int length = cycleLength(head);
        if(length == 0) return null;
        ListNode first = head;
        ListNode second = head;
        while(length>0){
            second = second.next;
            length--;
        }
        while(first!=second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
}