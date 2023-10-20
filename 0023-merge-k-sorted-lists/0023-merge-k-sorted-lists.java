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
    ListNode merge(ListNode l1 , ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode currNode = null;
        if(l1.val <=l2.val){
            currNode = l1;
            currNode.next = merge(l1.next , l2);
            //return l1;
        }
        else{
            currNode = l2;
            currNode.next = merge(l1 , l2.next);
            //return l2;
        }
        return currNode;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        ListNode resHead = merge(lists[0] , lists[1]);
        for(int i=2;i<lists.length;i++){
            resHead = merge(resHead , lists[i]);
        }

        return resHead;
    }
}