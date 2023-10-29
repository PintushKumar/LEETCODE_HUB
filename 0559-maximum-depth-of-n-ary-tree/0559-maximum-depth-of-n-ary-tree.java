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
    public int maxDepth(Node root) {
        if(root == null ){
            return 0;
        }
        Queue<Node> q= new ArrayDeque<>();
        q.add(root);
        int height = 0;
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                Node curr = q.remove();
                for(Node next : curr.children){
                    q.add(next);
                }
            }
            height++;
        }
        return height;
    }
}