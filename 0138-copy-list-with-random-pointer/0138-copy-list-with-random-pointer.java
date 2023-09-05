/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Create a new head for the deep copy linked list
        Node newHead = new Node(0);
        // Pointer to traverse the new linked list
        Node pointNewHead = newHead;
        // Pointer to traverse the original linked list
        Node curr = head;
        // HashMap to store mappings from original nodes to new nodes
        HashMap<Node, Node> map = new HashMap<>();
        
        // First pass: Create new nodes for each original node and populate the map
        while (curr != null) {
            // Create a new node with the same value as the original node
            Node temp = new Node(curr.val);
            // Add the mapping from the original node to the new node
            map.put(curr, temp);
            // Connect the new node to the new linked list
            pointNewHead.next = temp;
            // Move pointers forward
            pointNewHead = pointNewHead.next;
            curr = curr.next;
        }

        // Second pass: Set random pointers in the new linked list based on the map
        curr = head;
        pointNewHead = newHead.next;

        while (curr != null) {
            // Get the random pointer of the original node
            Node temp = curr.random;
            // Get the corresponding new node from the map
            Node tempRandom = map.get(temp);
            // Set the random pointer of the new node
            pointNewHead.random = tempRandom;
            // Move pointers forward
            pointNewHead = pointNewHead.next;
            curr = curr.next;
        }
        
        // Return the head of the deep copy linked list (skip the dummy node)
        return newHead.next;
    }
}
