/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head;
        ListNode second = head;
        ListNode prev = dummy;
        int idx = 0;
        while(idx != n){
            first = first.next;
            idx++;
        }
        while(first != null){
            prev = second;
            second = second.next;
            first = first.next;
        }
        prev.next  = second.next;
        second.next = null;
        return dummy.next;
    }
}
