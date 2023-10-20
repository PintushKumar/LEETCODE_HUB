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

// ********************************* Brute Force Solution **********************
/*

 class Solution {
    public int length(ListNode  head){
        if(head == null){
            return 0;
        }
        return 1+length(head.next);
    }
    public ListNode deleteMiddle(ListNode head) {
        int len = length(head);
        int mid = (len/2);
        ListNode res = new ListNode(-1);
        ListNode tres = res;
        ListNode temp = head;
    
        while(mid!=0){
            tres.next = temp;
            tres = tres.next;
            temp = temp.next;
            mid--;
        }
        tres.next = temp.next;
        
        return res.next;
    }
}

*/


class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        
        ListNode  slow = head;
        ListNode  fast = head.next.next;

        while(fast!= null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}