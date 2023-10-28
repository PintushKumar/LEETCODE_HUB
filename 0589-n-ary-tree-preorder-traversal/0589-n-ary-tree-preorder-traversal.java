/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void preOrder(Node root , List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        for(Node next : root.children){
            preOrder(next , res);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root , res );
        return res;
    }
}