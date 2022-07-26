/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0;
        int lenB = 0;
        while(currA!=null)
        {
            currA = currA.next;
            lenA++;
        }
        while(currB!=null)
        {
            currB = currB.next;
            lenB++;
        }
        if(lenA>lenB)
        {
            int move = lenA-lenB;
            while(move!=0){
                headA=headA.next;
                move--;
            }
            while(headA!=headB)
            {
                headA=headA.next;
                headB=headB.next;
            }
        }
        else if(lenB>lenA)
        {
            int move = lenB-lenA;
            while(move!=0){
                headB=headB.next;
                move--;
            }
            while(headA!=headB)
            {
                headA=headA.next;
                headB=headB.next;
            }
        }
        else
        {
           while(headA!=headB)
            {
                headA=headA.next;
                headB=headB.next;
            } 
        }
        
        return headA;
    }
}