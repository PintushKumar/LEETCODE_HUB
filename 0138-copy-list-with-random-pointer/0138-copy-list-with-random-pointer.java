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
        Node newHead = new Node(0);
        Node pointNewHead = newHead;
        Node curr = head;
        HashMap<Node , Node > map = new HashMap<>();
        while(curr != null){
            Node temp = new Node(curr.val);
            map.put(curr , temp);
            pointNewHead.next = temp;
            pointNewHead = pointNewHead.next;
            curr = curr.next;
        }

        curr = head;
        
        pointNewHead = newHead.next;

        while(curr != null){
            Node temp = curr.random;
            Node tempRandom = map.get(temp);
            pointNewHead.random = tempRandom;
            pointNewHead = pointNewHead.next ;
            curr = curr.next;
        }
        return newHead.next;
    }
}