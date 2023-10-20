class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // Skip the node with the specified value
            } else {
                current = current.next; // Move to the next node
            }
        }

        return dummy.next; // The modified list starts from the next of the dummy node
    }
}
