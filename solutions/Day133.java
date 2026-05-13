public class Day133 {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int n = nums.size();
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums.get(i) > nums.get(stack.peek())) {
                int oldIndex = stack.pop();
                ans[oldIndex] = nums.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
}