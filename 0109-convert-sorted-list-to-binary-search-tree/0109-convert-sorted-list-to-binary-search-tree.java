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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Base case: If the input linked list is empty, return null.
        if (head == null) {
            return null;
        }
        
        // Base case: If there's only one element in the linked list, create a TreeNode with that value and return it.
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        // Initialize two pointers: slow and fast for finding the middle of the linked list.
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev_slow = null; // Pointer to the node just before 'slow'.

        // Traverse the linked list to find the middle using the slow and fast pointers.
        while (fast != null && fast.next != null) {
            prev_slow = slow; // Update prev_slow to the current 'slow'.
            slow = slow.next; // Move 'slow' one step at a time.
            fast = fast.next.next; // Move 'fast' two steps at a time.
        }

        // Create a TreeNode with the value of the middle node found.
        TreeNode root = new TreeNode(slow.val);

        // Break the linked list into two halves by updating 'prev_slow' and setting 'slow.next' to null.
        prev_slow.next = null;

        // Recursively build the left and right subtrees using the two halves of the linked list.
        root.left = sortedListToBST(head); // Left subtree: Nodes before the middle.
        root.right = sortedListToBST(slow.next); // Right subtree: Nodes after the middle.

        // Return the root of the resulting binary search tree.
        return root;
    }
}
