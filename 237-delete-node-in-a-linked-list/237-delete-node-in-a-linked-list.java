/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       
        ListNode n = node.next;
        node.val = n.val;
        node.next = node.next.next;
            
    }
    
}