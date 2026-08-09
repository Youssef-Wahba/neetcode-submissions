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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp= dummy;
        boolean hasRem = false;
        while(l1!=null && l2!=null){
            int add = l1.val + l2.val;
            if(hasRem) add++;
            int nextVal;
            if(add%10 != add){
                nextVal = add%10;
                hasRem = true;
            }
            else{
                nextVal = add;
                hasRem = false;
            }
            tmp.next = new ListNode(nextVal);
            tmp = tmp.next;
            if(l1.next == null && l2.next!=null) l1.next = new ListNode(0);
            if(l2.next == null && l1.next!=null) l2.next = new ListNode(0);

            l2 = l2.next;
            l1 = l1.next;
        }
        if(hasRem){
            tmp.next = new ListNode(1);
        }
        return dummy.next;
    }
}
