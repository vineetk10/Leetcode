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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        
        while(!pq.isEmpty())
        {
            ListNode n = pq.poll();
            node.next = n;
            node = node.next;
            
            if(n.next!=null)
            {
                pq.add(n.next);
            }
        }
        
        return head.next!=null ? head.next : null;
    }
}