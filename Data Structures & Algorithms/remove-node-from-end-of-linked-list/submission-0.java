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
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        int idx = len - n;
        ListNode dummy = new ListNode (-1);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;
        while(idx != 0){
            prev = current;
            current = current.next;
            idx--;
        }
        prev.next = current.next;
        current.next = null;
        return dummy.next;
    }
}
