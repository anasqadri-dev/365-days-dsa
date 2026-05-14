class Day134 {
    public int size(ListNode head){
        int size=0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public int pow(int base, int exponent){
        if(exponent==0) return 1;
        int result = 1;
        for(int i=1; i<= exponent; i++)
            result*=base;
        return result;
    }
    public int getDecimalValue(ListNode head) {
        if(head==null) return 0;
        int decimal = 0;
        int power = size(head) - 1;
        ListNode temp = head;
        while(power>=0){
            decimal = decimal + (pow(2,power)*temp.val);
            temp = temp.next;
            power--;
        }
        return decimal;
    }
}