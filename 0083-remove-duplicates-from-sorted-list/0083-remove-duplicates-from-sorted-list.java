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
    public ListNode deleteDuplicates(ListNode head) {

// **************** Iterative Solution **********************

        // ListNode temp = head;
        // while(temp != null){
        //     ListNode curtemp = temp;
        //     int prevVal = temp.val;
        //     while(curtemp != null && curtemp.val == prevVal){
        //         curtemp = curtemp.next;
        //     }
        //     temp.next = curtemp;
        //     temp = temp.next;
        // }
        // return head;
// **********************************************************

        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}