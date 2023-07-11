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
    class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node , int state){
            this.node = node;
            this.state = state;
        }
    }
    TreeNode getNextInorder(Stack<Pair> st){
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state ==1){
                // preOrder Traversal 
                top.state++;
                if(top.node.left != null){
                    st.push(new Pair(top.node.left , 1));
                }
            } else if(top.state ==2){
                // inOrder Traversal 
                top.state++;
                if(top.node.right != null){
                    st.push(new Pair(top.node.right , 1));
                }
                return top.node;
            }else{
                // postOrder Traversal
                st.pop();
            }
        }
        return null;
    }
    public void recoverTree(TreeNode root) {
        if(root == null){
            return ;
        }
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root , 1));
        TreeNode curr = getNextInorder(st);
        TreeNode prev = null;
        TreeNode a = null  , b = null;
        while(curr != null){
            if(prev == null){
                prev = curr;
                curr = getNextInorder(st);
            }else if(prev.val>curr.val){
                if(a==null){
                    a= prev;
                }
                b=curr;
                prev = curr;
                curr = getNextInorder(st);
            }else{
                prev = curr;
                curr = getNextInorder(st);
            }
        }
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}