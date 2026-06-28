class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null; 

        ListNode prev = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        ListNode first = head;
        ListNode secondHalf = prev;

        while (secondHalf != null) {
            ListNode next1 = first.next;
            ListNode next2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = next1;

            first = next1;
            secondHalf = next2;
        }
    }
}