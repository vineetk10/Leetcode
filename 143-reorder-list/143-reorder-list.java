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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        
        while(curr!=null)
        {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        
        ListNode f = head;
        ListNode s = prev;
        
        while(f!=s && f.next!=s)
        {
            ListNode ftemp = f.next;
            f.next = s;
            f = ftemp;
            ListNode stemp = s.next;
            s.next = f;
            s = stemp;
        }
    }
}











// ListNode slow = head;
//         ListNode fast = head;
        
//         while(fast!=null && fast.next!=null)
//         {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         ListNode prev = null;
//         ListNode curr = slow;
        
//         while(curr!=null)
//         {
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
        
//         ListNode f = head;
//         ListNode s = prev;
        
//         while(f!=s && f.next!=s)
//         {
//             ListNode ftemp = f.next;
//             f.next = s;
//             f = ftemp;
//             ListNode stemp = s.next;
//             s.next = f;
//             s = stemp;
//         }



// ListNode temp = head.next;
        
//         ListNode fast = head;
//         ListNode slow = head;
        
//         while(fast!=null && fast.next!=null)
//         {
//             fast = fast.next.next;
//             slow = slow.next;
//         }
        
//         ListNode prev = null;
//         ListNode curr = slow;
        
//         while(curr!=null)
//         {
//             // System.out.println(slow.val);
//             // slowNext = slow.next;
//             // ListNode slowNextNext = slowNext.next;
//             ListNode next = curr.next;
//             // cur.next = curr;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
            
//             // slowNext = slowNextNext;
//             // if(slowNextNext==null)
//             //     break;
//         }
//         System.out.println(prev.val);
//         // while(slow!=null)
//         // {
//         //     System.out.println(slow.val);
//         //     slow = slow.next;
//         // }
//         while(head!=prev && head.next!=prev)
//         {
//             System.out.println(head.val+" "+prev.val);
//             temp = head.next;
//              ListNode t2 = prev.next;
//             head.next = prev;
//             head = temp;
//             // System.out.println(slow.val);
           
//             prev.next = temp;
//             prev = t2;
//         }