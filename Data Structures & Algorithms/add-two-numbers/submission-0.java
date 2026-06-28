class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while(curr1 != null && curr2 != null){
            int sum = curr1.val + curr2.val + carry;
            int val = sum%10;
            carry = sum/10;
            ListNode toAdd = new ListNode(val);
            prev.next = toAdd;
            prev = prev.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1 != null){
            int sum = curr1.val + carry;
            int val = sum%10;
            carry = sum/10;
            ListNode toAdd = new ListNode(val);
            prev.next = toAdd;
            prev = prev.next;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            int sum = curr2.val + carry;
            int val = sum%10;
            carry = sum/10;
            ListNode toAdd = new ListNode(val);
            prev.next = toAdd;
            prev = prev.next;
            curr2 = curr2.next;
        }

        if(carry != 0){
            ListNode toAdd = new ListNode(carry);
            prev.next = toAdd;
            prev = prev.next;
        }
        return dummy.next;
    }
}
