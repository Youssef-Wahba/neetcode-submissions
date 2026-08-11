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
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));
        heap.addAll(Arrays.asList(lists));
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            tail.next = node;
            tail= tail.next;
            if(node.next!=null) heap.offer(node.next);
        }
        return dummy.next;
    }
}
