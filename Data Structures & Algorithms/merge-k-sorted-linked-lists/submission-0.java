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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        for(int i=0;i<lists.length;i++){
            dummy.next = mergeTwoLists(dummy.next,lists[i]);
        }
        return dummy.next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = new ListNode(-1);
        dummy = tail;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                tail.next = curr1;
                tail = tail.next;
                curr1 = curr1.next;
            } else {
                tail.next = curr2;
                tail = tail.next;
                curr2 = curr2.next;
            }
        }
        while (curr1 != null) {
            tail.next = curr1;
            tail = tail.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            tail.next = curr2;
            tail = tail.next;
            curr2 = curr2.next;
        }
        return dummy.next;
    }
}
